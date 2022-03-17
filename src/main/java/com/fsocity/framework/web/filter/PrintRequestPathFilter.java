package com.fsocity.framework.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Slf4j
public class PrintRequestPathFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long begin = System.currentTimeMillis();
        String method = request.getMethod().toUpperCase();
        String uri = request.getRequestURI();
        filterChain.doFilter(request, response);
        log.info("{} {} 耗时 {} 毫秒。", method, uri, System.currentTimeMillis() - begin);
    }
    
}
