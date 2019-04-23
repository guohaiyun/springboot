package cn.wmyskz.springboot.util.threadPool;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月19日 16:44
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class scheduledThreadPoolTest {
    //创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
//表示延迟1秒后每3秒执行一次，定期执行示例代码如下：
//ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//public void run() {
//        System.out.println("delay 1 seconds, and excute every 3 seconds");
//        }
//        }, 1, 3, TimeUnit.SECONDS);