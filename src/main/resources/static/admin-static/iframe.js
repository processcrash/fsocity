(function ($) {
    var config = {
        // iframe 外的 id
        iframeWrapperId: 'admin-content',
        // iframe id
        iframeId: 'iframe-content',
        // iframe 标签的 class
        iframeClass: '',
    }
    
    function createContentIframe(src) {
        var $if = $('#' + config.iframeWrapperId)
        $if.html('')
        var content_iframe = '<iframe ' +
                'class="' + config.iframeClass + '" ' +
                'id="' + config.iframeId + '" ' +
                'src="' + src + '" ' +
                'width="100%" height="100%" ' +
                'frameborder="0" marginheight="0" marginwidth="0" loading="eager" ' +
                '"></iframe>'
        $if.html(content_iframe)
    }
    
    /**
     * 加载所有的 iframe 标签
     */
    function loadIframePages(currentUrl) {
        var menu_iframe = $('#menu-iframe')
        
        var m = queryStringByName(currentUrl, 'm')
        var url = queryStringByName(currentUrl, 'url')
        
        // 1. 解析 url 参数, 后设置 iframe url 属性, 加载页面.
        menu_iframe.attr('src', menu_url + '?m=' + m)
        createContentIframe(url)
    }
    
    $(function () {
        // 1. 加载 iframe
        loadIframePages(window.location.href)
        /**
         * 切换内容方法
         */
        window.switchContent = function (contentUrl) {
            // 判断当前的 m 是否正确?
            var m = queryStringByName(window.location.href, 'm')
            console.log('m=', m)
            
            // 切换 content iframe 的 src
            createContentIframe(contentUrl)
            
            /**
             * 如果切换 url 需要把 url 链接加载到浏览器 url 浏览历史记录中,
             * 使浏览器返回时可以正常使用.
             */
            var truthUrl = iframed_prefix_url + '?m=' + m + '&url=' + contentUrl
            // 改变浏览器 url
            if (window.location.href.indexOf("source") <= 0) {
                window.history.pushState("", $('title').text(), truthUrl);
                console.log(history)
            }
        }
        
        /**
         * 获取内容 iframe 的链接
         *
         * @returns {*|void}
         */
        window.getContentUrl = function () {
            var content_iframe = $('#' + content_iframe_id)
            return content_iframe.attr('src')
        }
        
        // 监听浏览器后退事件, 如果触发该事件, 则重新加载 iframe 内容即可.
        window.addEventListener('popstate', function (e) {
            // 获取跳转的 url
            var url = queryStringByName(window.location.href, 'url')
            if (url) {
                // 加载 iframe 即可
                loadIframePages(window.location.href)
            }
        })
        
    })
    
})(jQuery);
