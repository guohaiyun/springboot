package cn.wmyskz.springboot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年01月02日 11:56
 */
@Configuration
public class MywebConfig implements WebMvcConfigurer{

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration ir=registry.addInterceptor(new MyInterceptor());
//        ir.addPathPatterns("/**");
//        //配置静态资源拦截
//        ir.excludePathPatterns("/index","/*.js","/*.css");
////        ir.excludePathPatterns()
//    }

//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public FilterRegistrationBean filterRegist() {
//        FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new MyFilter());
////        Connec
////        frBean.addUrlPatterns(["/cookie_session/*"]);
//        frBean.addUrlPatterns("/*");
////        frBean.addInitParameter("exclusions", "*.js");
//        System.out.println("filter");
//        return frBean;
//    }
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(new MyHttpSessionListener());
//        return srb;
//    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
}
