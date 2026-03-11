package fry.ujsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@WebFilter(urlPatterns = "/*")
public class JspUrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();
        String method = httpRequest.getMethod();

        // 检查URL中是否包含.jsp（忽略大小写）
        if (requestURI.toLowerCase().contains(".jsp")) {
            // 移除所有.jsp（忽略大小写）
            String newURI = requestURI.replaceAll("(?i)\\.jsp", "");

            // 如果移除后URL为空或只剩上下文路径，则重定向到根路径
            if (newURI.isEmpty() || newURI.equals(contextPath)) {
                newURI = contextPath + "/";
            }

            // 获取原始参数
            Map<String, String[]> parameterMap = httpRequest.getParameterMap();

            if ("POST".equalsIgnoreCase(method)) {
                // POST请求：使用RequestDispatcher转发，保留参数
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(newURI);
                if (dispatcher != null) {
                    // 创建包装器确保参数可用
                    HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {
                        @Override
                        public Map<String, String[]> getParameterMap() {
                            return parameterMap;
                        }

                        @Override
                        public String getParameter(String name) {
                            String[] values = parameterMap.get(name);
                            return values != null && values.length > 0 ? values[0] : null;
                        }

                        @Override
                        public Enumeration<String> getParameterNames() {
                            return Collections.enumeration(parameterMap.keySet());
                        }

                        @Override
                        public String[] getParameterValues(String name) {
                            return parameterMap.get(name);
                        }
                    };

                    dispatcher.forward(wrapper, response);
                    return;
                }
            } else {
                // GET请求：保留查询参数进行重定向
                String queryString = httpRequest.getQueryString();
                String redirectUrl = newURI + (queryString != null ? "?" + queryString : "");
                httpResponse.sendRedirect(redirectUrl);
                return;
            }
        }

        // 如果不包含.jsp，继续处理请求
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // 初始化方法
    }

    @Override
    public void destroy() {
        // 销毁方法
    }
}