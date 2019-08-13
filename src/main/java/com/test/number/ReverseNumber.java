package com.test.number;

import java.text.NumberFormat;

/**
 * 翻转数字
 */
public class ReverseNumber {


    public static void main(String[] args) {
        int num = 1646324359;
        int result = reverse(num);
        System.out.println("传入参数 = " + num);
        System.out.println("返回结果 = " + result);
    }

    /**
     * 输入: 123
     * 输出: 321
     *
     * 输入: -123
     * 输出: -321
     *
     *
     * 输入: 120
     * 输出: 21
     *
     * 翻转后出现溢出 返回0
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //判断正负
        boolean flag = true;
        if(x < 0){
            flag = false;
        }

        StringBuilder sb = new StringBuilder();

        try{
            if(flag){
                //正
                sb.append(x);
               return Integer.parseInt(sb.reverse().toString());
            }else{
                //负
                String str = x+"";
                str = str.substring(1,str.length());
                System.out.println(" str = " + str);
                String sy = "-";

                sb.append(str);
              return  Integer.parseInt(sy + sb.reverse().toString());
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }

    }
}
