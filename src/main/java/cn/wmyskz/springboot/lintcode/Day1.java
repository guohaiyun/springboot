package cn.wmyskz.springboot.lintcode;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年05月10日 19:34
 */
public class Day1 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        int value = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            value = value^arr[i];
        }
        System.out.println(value);
    }
}
