package cn.wmyskz.springboot.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年05月10日 19:50
 */
public class Day3 {
    public static void main(String[] args) {
        /**
         * @param n: The number of digits
         * @return: All narcissistic numbers with n digits
         */
        int n=4;
        double maxValue=maxValue(n);
        double minValue=minValue(n);
        double minminValue=0;
        for (double i = minValue; i <maxValue ; i++) {
            double val=0.0;
            double temp=0.0;
            for (int z=n;i>0;i--){
               temp = minValue /Math.pow(10,n);
               val = Math.pow(temp,n)+val;

            }


        }
    }


    public static double maxValue(int n){
        double value =0.0;
        for (int i = 0; i <n; i++) {
            value = 0+ Math.pow(10,i);
        }
        return  (9*value);
    }
    public static double minValue(int n){
        double value =0.0;
        for (int i = 0; i <n; i++) {
            value = 0+ Math.pow(10,i);
        }
        return  value;
    }
}
