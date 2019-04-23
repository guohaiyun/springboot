package cn.wmyskz.springboot.util;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年01月02日 10:08
 */
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(servletRequest.getParameter("name"));
//        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
//        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
//        if(hrequest.getRequestURI().indexOf("/index") != -1 ||
//                hrequest.getRequestURI().indexOf("/asd") != -1 ||
//                hrequest.getRequestURI().indexOf("/online") != -1 ||
//                hrequest.getRequestURI().indexOf("/login") != -1
//        ) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            wrapper.sendRedirect("/login");
//        }
//        if(hrequest.getRequestURI().lastIndexOf(".html")!=-1){
//
//        }
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
////
//        if (session.getAttribute("ggg") == null) {
//            session.setAttribute("ggg","aaa");
//            response.sendRedirect("hah.ftl");
//        } else {

            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }
}
