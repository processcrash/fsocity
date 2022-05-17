(function ($, window, document) {
    
    // 如果有 bootstrapSwitch
    if ($.fn.bootstrapSwitch) {
        $("[data-bootstrap-switch]").each(function () {
            $(this).bootstrapSwitch({
                state: true,
                onText: '开启',
                offText: '关闭',
            })
        })
    }
    
})(jQuery, window, document)

//------ 全局变量 start ------//

// 是否在 iframe 标签中
window.isInIframe = parent.window.location.href !== window.location.href

//  myUtils
var myUtils = {
    arrayToObj: function (arr) {
        var val = {}
        for (var i = 0; i < arr.length; i++) {
            var fd = arr[i]
            val[fd.name] = fd.value; // 通过变量，将属性值，属性一起放到对象中
        }
        return val
    },
    getPath(url) {
        if (!url) return window.location.pathname
        else {
            if (url.indexOf('://') !== -1) {
                url = url.substr(url.indexOf('://') + 3)
            }
            if (url.indexOf("?") !== -1) {
                url = url.substr(0, url.indexOf('?'))
                url = url.substr(url.indexOf('/'))
            }
            return url
        }
    },
    parseQS: function (url) {
        if (!url) url = window.location.href
        var result = {}
        if (url.indexOf("?") !== -1) { // 如果链接中有?，则说明连接中有qs
            var qs = url.substr(url.indexOf('?'))
            qs = qs.substr(1)
            var strs = qs.split("&");
            for (var i = 0; i < strs.length; i++) {
                result[strs[i].split('=')[0]] = unescape(strs[i].split('=')[1])
            }
        }
        return result;
    },
    QSStringify: function (obj) {
        if (!obj) return ''
        if (JSON.stringify(obj) === '{}') return ''
        
        var result = ''
        if (obj instanceof Object) {
            var arr = []
            for (var name in obj) {
                arr.push(name + '=' + obj[name])
            }
            result = '?' + arr.join('&')
        }
        
        return result
    },
}
/*
axios.request(config)
axios.get(url[, config])
axios.delete(url[, config])
axios.head(url[, config])
axios.options(url[, config])
axios.post(url[, data[, config]])
axios.put(url[, data[, config]])
axios.patch(url[, data[, config]])
 */
var axiosUtils = {
    validate: function () {
        // 如果有 axios
        if (axios) {
            return true
        }
        // 如果没有则警告一下
        console.error('请引入axios包！')
        return false
    },
    axiosGet: function (url, config) {
        this.validate()
        return axios.get(url, config)
                .then(this.axiosResolve)
                .catch(this.axiosReject)
    },
    axiosPut: function (url, data, config) {
        this.validate()
        return axios.put(url, data, config)
                .then(this.axiosResolve)
                .catch(this.axiosReject)
    },
    axiosDelete: function (url, config) {
        this.validate()
        return axios.delete(url, config)
                .then(this.axiosResolve)
                .catch(this.axiosReject)
                .then(this.axiosResolveData)
    },
    axiosRequest: function (config) {
        this.validate()
        return axios.request(config)
                .then(this.axiosResolve)
                .catch(this.axiosReject)
    },
    axiosPost: function (url, data, config) {
        this.validate()
        return axios
                .post(url, data, config)
                .then(this.axiosResolve)
                .catch(this.axiosReject)
                .then(this.axiosResolveData)
    },
    axiosResolve: function (response) {
        var data = response.data
        if (data.code !== 0) {
            layer.msg('提交错误！原因：' + data.message, {
                icon: 5,
                time: 6000
            });
            return Promise.reject()
        }
        
        return data.data
    },
    axiosReject: function (error) {
        layer.msg('网络异常，请重试！', {
            icon: 5,
            time: 6000
        })
        return Promise.reject()
    },
    axiosResolveData: function (data) {
        // 尝试关闭parent的弹窗
        if (isInIframe) {
            // 先得到当前iframe层的索引
            try {
                var index = parent.layer.getFrameIndex(window.name)
                parent.layer.close(index) // 关闭
                parent.layer.msg('提交成功！', {
                    icon: 1,
                    time: 6000
                })
            }
            catch (e) {
                console.error(e)
            }
        }
        
        return data
    },
}

var operateUtils = {
    defaultConfig: {
        title: '标题',
        width: '80%',
        height: '80%',
    },
    getConfig: function (config) {
        return Object.assign({}, this.defaultConfig, config)
    },
    refresh: function () {
        $bootstrapTable.bootstrapTable('refresh')
    },
    confirm: function (txt) {
        if (!txt) txt = '确定操作吗？'
        return new Promise(function (resolve, reject) {
            layer.confirm(txt, function (index) {
                resolve()
                layer.close(index)
            }, function (index) {
                reject()
                layer.close(index)
            })
        })
    },
    ok: function (txt) {
        txt = txt ? txt : '成功！'
        parent.layer.msg(txt, {
            icon: 1,
            time: 6000
        })
    },
    open: function (url, config) {
        // 递归向上调用
        if (isInIframe) return parent.operateUtils.open(url, config)
        if (!url) url = '/'
        config = this.getConfig(config)
        return new Promise(function (resolve, reject) {
            layer.open({
                type: 2,
                title: config.title,
                shadeClose: true, // 点击遮罩层关闭
                maxmin: true, // 显示最大化按钮
                area: [config.width, config.height], // 宽高
                content: url,
                end: function (index) {
                    resolve()
                }
            })
        })
    },
    openById: function (id, key, config) {
        var path = myUtils.getPath()
        path = path.substr(0, path.lastIndexOf('/'))
        var qsObj = myUtils.parseQS()
        qsObj.id = id
        var qs = myUtils.QSStringify(qsObj)
        var url = path + '/' + key + qs
        return this.open(url, config)
    },
    detail: function (id) {
        return this
                .openById(id, 'detail', {
                    title: '查看'
                })
    },
    edit: function (id) {
        return this
                .openById(id, 'edit', {
                    title: '编辑',
                })
                .then(function () {
                    this.operateUtils.refresh()
                })
    },
    add: function () {
        var path = myUtils.getPath()
        path = path.substr(0, path.lastIndexOf('/'))
        var url = path + '/add'
        return this
                .open(url, {
                    title: '添加',
                })
                .then(function () {
                    this.operateUtils.refresh()
                })
    },
    del: function (id) {
        var path = myUtils.getPath()
        path = path.substr(0, path.lastIndexOf('/'))
        var url = path + '/delete?id=' + id
        layer.confirm('确定删除吗?', function (index) {
            axiosUtils
                    .axiosDelete(url)
                    .then(function (data) {
                        layer.close(index)
                        $bootstrapTable.bootstrapTable('refresh')
                    })
        })
    }
}
//------ 全局变量 end ------//
