package cn.wmyskz.springboot.thread;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.concurrent.*;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月19日 20:14
 */
@RestController
@RequestMapping("/thread")
@Log4j2
public class threadController {
    ThreadPoolExecutor cachedThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            10L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    ThreadPoolExecutor fixedThreadPool = new ThreadPoolExecutor(4, 8,
            10L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    @RequestMapping("/test1")
    public void test1(){
        cachedThreadPool.execute((new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    log.error(e);
                }
                log.error("cachedThreadPool");
                int i=1/0;
            }
        }));

    }

    @RequestMapping("/test2")
    public void test2(){
        singleThreadExecutor.execute((new Runnable() {
            @Override
            public void run() {
                System.out.println("singleThreadExecutor");
            }
        }));
    }
    @RequestMapping("/test3")
    public void test3(){
        scheduledThreadPool.execute((new Runnable() {
            @Override
            public void run() {
                System.out.println("测试scheduledThreadPool");
            }
        }));
    }
    @RequestMapping("/test4")
    public void test4() {
        fixedThreadPool.execute ((new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    log.error(e);
                }

                log.error("测试fixedThreadPool");
            }
        }));


    }
    @RequestMapping("/test5")
    public void test5() throws Exception{
        while (true) {
            System.out.println();

            int queueSize = fixedThreadPool.getQueue().size();
            System.out.println("当前排队线程数fixedThreadPool：" + queueSize);

            int activeCount = fixedThreadPool.getActiveCount();
            System.out.println("当前活动线程数fixedThreadPool：" + activeCount);

            long completedTaskCount = fixedThreadPool.getCompletedTaskCount();
            System.out.println("执行完成线程数fixedThreadPool：" + completedTaskCount);

            long taskCount = fixedThreadPool.getTaskCount();
            System.out.println("总线程数fixedThreadPool：" + taskCount);

            Thread.sleep(3000);
            System.out.println(Runtime.getRuntime().availableProcessors());
        }
    }
    @RequestMapping("/test6")
    public void test6() throws Exception{
        while (true) {
            System.out.println();

            int queueSize = cachedThreadPool.getQueue().size();
            System.out.println("当前排队线程数cachedThreadPool：" + queueSize);

            int activeCount = cachedThreadPool.getActiveCount();
            System.out.println("当前活动线程数cachedThreadPool：" + activeCount);

            long completedTaskCount = cachedThreadPool.getCompletedTaskCount();
            System.out.println("执行完成线程数cachedThreadPool：" + completedTaskCount);

            long taskCount = cachedThreadPool.getTaskCount();
            System.out.println("总线程数cachedThreadPool：" + taskCount);

            Thread.sleep(3000);
//            System.out.println(Runtime.getRuntime().availableProcessors());
        }
    }
}
