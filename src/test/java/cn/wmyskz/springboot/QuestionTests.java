package cn.wmyskz.springboot;

import cn.wmyskz.springboot.demo.service.CTest;
import cn.wmyskz.springboot.demo.service.CTest1;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class QuestionTests {


//    @Test
//    public void test1() {
//        System.out.println(1);
////        nthUglyNumber(7);
//    }
//    @Test
//    public void nthUglyNumber() {
//        int n=1665;
//        int count=2;
//        int val=1;
//        if(n==1){
//            System.out.println(1);
//        }
//        int temp;
//        while(count<=n){
//            val++;
//            temp=val;
//            while(true){
//                if(temp%2==0){
//                    temp=temp/2;
//                    if(temp==1){
//                        break;
//                    }
//                }else if(temp%3==0){
//
//                    temp=temp/3;
//                    if(temp==1){
//                        break;
//                    }
//                }else if(temp%5==0){
//                    temp=temp/5;
//                    if(temp==1){
//                        break;
//                    }
//                }else{
//                    val++;
//                    temp=val;
//                }
//            }
//
//            count++;
//
//            // val=temp;
//        }
//        System.out.println(val);
        // write your code here
//    }

    public static void main(String[] args) {

//        long start=System.currentTimeMillis();
        Thread t1 = new Thread(new CTest());//创建一个线程
                t1.start();




        Thread t2 = new Thread(new CTest1());//创建一个线程
                t2.start();
        Thread t3 = new Thread(new CTest1());//创建一个线程
        t3.start();
        Thread t4 = new Thread(new CTest1());//创建一个线程
        t4.start();


//        System.out.println(System.currentTimeMillis()-start);
//        int n=10;
//        // Write your code here
//        Queue<Long> Q = new PriorityQueue<>();
//        HashSet<Long> inQ = new HashSet<Long>();
//        Long[] primes = new Long[3];
//        primes[0] = Long.valueOf(2);
//        primes[1] = Long.valueOf(3);
//        primes[2] = Long.valueOf(5);
//        for (int i = 0; i < 3; i++) {
//            Q.add(primes[i]);
//            inQ.add(primes[i]);
//        }
//        Long number = Long.valueOf(1);
//        for (int i = 1; i < n; i++) {
//            number = Q.poll();
//            for (int j = 0; j < 3; j++) {
//                if (!inQ.contains(primes[j] * number)) {
//                    Q.add(number * primes[j]);
//                    inQ.add(number * primes[j]);
//                }
//            }
//        }
//        System.out.println(number.intValue());
//        System.out.println(11);
    }


//    public int nthUglyNumber(int n) {
//        List<Integer> uglys = new ArrayList<Integer>();
//        uglys.add(1);
//
//        int p2 = 0, p3 = 0, p5 = 0;
//        // p2, p3 & p5 share the same queue: uglys
//
//        for (int i = 1; i < n; i++) {
//            int lastNumber = uglys.get(i - 1);
//            //每次取倍数中最大的值翻倍，直到大于当前数字位置
//            while (uglys.get(p2) * 2 <= lastNumber) p2++;
//            while (uglys.get(p3) * 3 <= lastNumber) p3++;
//            while (uglys.get(p5) * 5 <= lastNumber) p5++;
//            //每次取满足条件中最小的一个数作为List里面的值
//            uglys.add(Math.min(
//                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
//                    uglys.get(p5) * 5
//            ));
//        }
//
//        return uglys.get(n - 1);
//    }

//    }
}

