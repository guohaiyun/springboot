package cn.wmyskz.springboot.util;

import cn.wmyskz.springboot.exception.MyException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月28日 19:55
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println(binder.getTarget());
//        System.out.println(binder);

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {

        Map map = new HashMap();
        map.put("code", 300);
        map.put("msg", ex.getMessage());
        return map;
    }
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public Map why(Exception ex) {
//        Map map = new HashMap();
//        map.put("code", 250);
//        map.put("msg", ex.getMessage());
//        return map;
//    }
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map haha(Exception ex) {
        ex.getMessage();
        Map map = new HashMap();
        map.put("code", 888);
        map.put("msg", "校验错误");
        return map;
    }
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Map zz(Exception ex) {
        ex.getMessage();
        Map map = new HashMap();
        map.put("code", 999);
        map.put("msg", "校验错误");
        return map;
    }

    //MethodArgumentNotValidException
//    @ResponseBody
//    @ExceptionHandler(value = .class)
//    public Map why(Exception ex) {
//        Map map = new HashMap();
//        map.put("code", 250);
//        map.put("msg", ex.getMessage());
//        return map;
//    }
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Map vvv(Exception ex) {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", ex.getMessage());
        return map;

    }
//    @ExceptionHandler(value = MyException.class)
//    public String myErrorHandler(MyException ex) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("error");
////        modelAndView.addObject("code", ex.getCode());
////        modelAndView.addObject("msg", ex.getMsg());
//        return "index";
//    }
}
