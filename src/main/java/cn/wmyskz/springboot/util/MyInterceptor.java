//package cn.wmyskz.springboot.util;
//import java.io.PrintWriter;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.HandlerMapping;
//import org.springframework.web.servlet.ModelAndView;
///**
// * @author haiyun.guo
// * @Description:
// * @date 2019年01月02日 16:28
// */
//public class MyInterceptor implements HandlerInterceptor{
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//
//        HttpSession session=httpServletRequest.getSession();
//        if(session.getAttribute("ggg")==null){
//            httpServletResponse.setCharacterEncoding("utf-8");
//            httpServletResponse.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer=httpServletResponse.getWriter();
//            writer.write("请进行登陆");
//            System.out.println("请登陆");
//            return false;
//        }
//        System.out.println("preHandle被调用");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle被调用");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion被调用");
//    }
//
//}
