package com.test;

import java.util.Calendar;
import java.util.LinkedList;

public class Test {


    public static void main(String[] args) {
//    int a = 101_100_100;
//    long b = 1324_4545_343_3L;
//
//        System.out.println(a);
//        System.out.println(b);
//
//        System.out.println("=========");
//
//        int i = 1680;
//        int j = 640;
//        int res =  diguiGetSum(i,j);
//        System.out.println("返回结果 = " + res);
//
//        System.out.println( (1680*640) / res);
//
//        System.out.println(i / res );
//        System.out.println(j / res );

        //获取数组中的最大值 递归
        int[] arr = new int[]{2,54,5,46,8,892,56,90,121,453};
        int min = Integer.MIN_VALUE;
        int max = getMax(arr);
        System.out.println("最大值 = " + max);
    }

    /**
     * 递归求数组 中最大值
     * @param arr
     * @return
     */
    private static int getMax(int[] arr) {
        //先排序

        //在获取最大值
       return 0;

    }


    /**
     * 求最小公倍数
     * @param a
     * @param b
     * @return
     */
    public static int diguiGetSum(int a, int b){
        //int n = a % b;
        /*if(n > 1){
            int res = diguiGetSum(b,n);
        }else{
            return a;
        }*/

        return a % b != 0 ?  diguiGetSum(b,a % b) : b;
    }




}
