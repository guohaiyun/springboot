package cn.wmyskz.springboot.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年01月02日 18:51
 */
@Aspect
@Component
public class TimeCountAspect {
//    @Pointcut("execution(cn.wmyskz.springboot.*.controller.*(*)")
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("within(cn.wmyskz.springboot..*)")
    public void allPointCut(){

    }

//    @Pointcut("execution(public * cn.wmyskz.springboot.*.controller.LoginController.getFreeIndex2())")
//    public void timeMis2(){
//
//    }
    @Pointcut("within(cn.wmyskz.springboot.*.controller..*)")
    public void timeMis1(){

    }

    @Pointcut("within(cn.wmyskz.springboot.*.service..*)")
    public void timeMis3(){

    }
    //@annotation标识方法,@within标识类
    @Pointcut("@annotation(cn.wmyskz.springboot.util.TestCom)||@within(cn.wmyskz.springboot.util.TestCom)")
    public void test1(){

    }

    @Before("test1()")
    public void test(JoinPoint point){
        String print="";
        Class<?>clazz=point.getTarget().getClass();
        //获取类的注解
        if(clazz.isAnnotationPresent(TestCom.class)){
            TestCom testCom=clazz.getAnnotation(TestCom.class);
            print=testCom.value();
        }
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        //获取方法的注解
        if(targetMethod.isAnnotationPresent(TestCom.class)){
            TestCom com=targetMethod.getAnnotation(TestCom.class);
            print=com.value();
        }
        logger.info("取得数据"+print);

    }
//    @Around("servicePointCut() or annotated()")
    @Around("timeMis1()")
    public Object countTime(ProceedingJoinPoint point) throws Throwable{
            long start=System.currentTimeMillis();
            String nonstr = RandomStringUtils.randomAlphanumeric(8);
        HttpServletRequest request = null;
        Object obj = null;
        Object[] t=point.getArgs();
        StringBuffer logStr = new StringBuffer();
        try {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
        } catch (Exception e) {
            logger.warn("getRequst对象为空,请检查");
            throw e;
        }
        try {
                logStr.append("----------------thread-").append(Thread.currentThread().getId()).append(" ").append(point.getTarget().getClass().getName()).append(" 类的").append(point.getSignature().getName()).append( " 方法执行开始,nonstr=").append(nonstr).append(" ,").append(request.getRequestURL());
                if("POST".equals(request.getMethod())){
                    logStr.append(StringUtils.isBlank(Arrays.toString(t)) ? "":"?"+Arrays.toString(t));
                }else {
                    logStr.append(StringUtils.isBlank(request.getQueryString()) ? "":"?"+request.getQueryString());
                }
                logger.info(logStr);
            obj =point.proceed();
            }catch (Throwable ex){
                throw ex;
            }
        long endTime = System.currentTimeMillis();
        long diffTime = endTime - start;
        logStr.delete(0,logStr.length());
        logStr.append("----------------").append("thread-"+Thread.currentThread().getId()).append(" ").append( point.getTarget().getClass().getName() ).append( " 类的 " + point.getSignature().getName())
                .append( " 方法执行结束,nonstr=").append(nonstr).append(", 执行耗时[" ).append( diffTime ).append( " ms]-------------------");
        logger.info(logStr);
        return  obj;
    }
    @Around("timeMis3()")
    public Object countTime3(ProceedingJoinPoint point) throws Throwable{
        long start=System.currentTimeMillis();
        Object[] t=point.getArgs();
        Object obj = null;
        String nonstr = RandomStringUtils.randomAlphanumeric(5);
        StringBuffer logStr = new StringBuffer();
        try {
            logStr.append("----------------thread-").append(Thread.currentThread().getId()).append(" ").append(point.getTarget().getClass().getName()).append(" 类的").append(point.getSignature().getName()).append( " 方法执行开始,nonstr=").append(nonstr).append(Arrays.toString(t));
            obj=   point.proceed();
        }catch (Throwable ex){
            throw ex;
        }
        long endTime = System.currentTimeMillis();
        long diffTime = endTime - start;
        logStr.append("----------------").append("thread-"+Thread.currentThread().getId()).append(" ").append( point.getTarget().getClass().getName() ).append( " 类的 " + point.getSignature().getName())
                .append( " 方法执行结束,nonstr=").append(nonstr).append(", 执行耗时[" ).append( diffTime ).append( " ms]-------------------");

        logger.info(logStr);
        return obj;
    }
//    /**
//     * 异常通知
//     */
    @AfterThrowing(throwing = "ex", pointcut = "allPointCut()")
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        String logStr = "";
//        if (ex instanceof RuntimeException) {
//            logStr += ((RuntimeException) ex).getMessage();
//        }
        logStr += "----------------" +"thread-"+Thread.currentThread().getId()+" "+ jp.getTarget().getClass().getName() + " 类的 " + jp.getSignature().getName()+ " 方法发生异常"
                + "\n方法参数：" + Arrays.toString(jp.getArgs());
        logger.error(logStr, ex);
    }
}
