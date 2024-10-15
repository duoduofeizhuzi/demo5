package com.example.demo.filter;

import com.example.demo.interceptor.SuperheroHttpServletRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SuperheroFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            if ("POST".equalsIgnoreCase(httpRequest.getMethod()) || "PUT".equalsIgnoreCase(httpRequest.getMethod())) {
                SuperheroHttpServletRequestWrapper wrappedRequest = new SuperheroHttpServletRequestWrapper(httpRequest);
                String body = wrappedRequest.getBody();
                String cleanedBody = cleanJson(body);
                wrappedRequest.setBody(cleanedBody);
                chain.doFilter(wrappedRequest, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private String cleanJson(String body) {
        // 替换单引号为双引号，并处理没有引号的键
        body = body.replaceAll("'", "\"");
        // 使用正则表达式匹配没有引号的键，并加上引号
        body = body.replaceAll("(\\w+):", "\"$1\":");
        // 处理没有引号的值
        body = body.replaceAll(":\\s*(\\w+)", ": \"$1\"");
        return body;
    }
}

