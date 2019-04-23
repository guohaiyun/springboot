package cn.wmyskz.springboot.util.threadPool;

import java.util.concurrent.*;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月19日 16:32
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
//        创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
//
//        FixedThreadPool是一个典型且优秀的线程池，它具有线程池提高程序效率和节省创建线程时所耗的开销的优点。但是，在线程池空闲时，即线程池中没有可运行任务时，它不会释放工作线程，还会占用一定的系统资源。

        ExecutorService fixedThreadPool = new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ((ThreadPoolExecutor) fixedThreadPool).getActiveCount();
        ((ThreadPoolExecutor) fixedThreadPool).getTaskCount();
        ((ThreadPoolExecutor) fixedThreadPool).getLargestPoolSize();
        ((ThreadPoolExecutor) fixedThreadPool).getQueue();
        Runtime.getRuntime().availableProcessors();
    }
}
