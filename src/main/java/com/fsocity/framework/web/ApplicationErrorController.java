package com.fsocity.framework.web;

import com.fsocity.framework.exception.WebException;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author zail
 * @date 2022/2/24
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ApplicationErrorController implements ErrorController {
    
    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request, ModelMap model) {
        model.put("status", getStatusCode(request));
        model.put("timestamp", new Date());
        model.put("path", getErrorUri(request));
        model.put("code", ResponseStatusEnum.ERR.getCode());
        model.put("message", getError(request).getMessage());
        return new ModelAndView("thymeleaf/error", model);
    }
    
    @RequestMapping
    @ResponseBody
    public JsonResult error(HttpServletRequest request) {
        return JsonResult.err(ResponseStatusEnum.ERR.getCode(), getError(request).getMessage());
    }
    
    public static Exception getError(HttpServletRequest request) {
        Exception exception = (Exception) request.getAttribute(DefaultErrorAttributes.class.getName() + ".ERROR");
        if (exception == null) {
            exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        }
        if (exception == null) {
            exception = new WebException(ResponseStatusEnum.ERR.getMessage());
        }
        return exception;
    }
    
    public static String getErrorUri(HttpServletRequest request) {
        String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (request.getQueryString() != null) {
            uri += "?" + request.getQueryString();
        }
        return uri;
    }
    
    public static Integer getStatusCode(HttpServletRequest request) {
        return (Integer) request.getAttribute("javax.servlet.error.status_code");
    }
}
