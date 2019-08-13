package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PolishNotationDemo {

    public static void main(String[] args) {
        //(3+2)*5-8
       // String str = "3 2 + 5 * 8 -";
        //123+4*+5-

        String str = "1 2 3 + 4 * + 5 -";

        List<String> list = getList(str);

        Double result = calculation(list);
        System.out.println("计算: (3+2)*5-8 " );
        System.out.println("结果 =  " +  result);
    }

    /**
     * 将 逆波兰表达式 分割存入到一个list中
     * @param list
     * @return
     */
    private static Double calculation(List<String> list) {
        Stack<String> stack = new Stack<String>();

        //判断是否为运算符
        for(String str : list){
            if(isSymbol(str)){
                //是运算符
                Double num1 = Double.parseDouble(stack.pop());
                Double num2 = Double.parseDouble(stack.pop());
                Double resNumber = getSum(num1,num2,str);
                stack.push(resNumber.toString());

            }else{
                stack.push(str);
            }
        }

        return Double.parseDouble(stack.pop());
    }

    private static boolean isSymbol(String val) {
        return "+".equals(val) || "-".equals(val) || "*".equals(val) || "/".equals(val);
    }

    private static List<String> getList(String str) {

        String[] arr = str.split(" ");

        int len = arr.length;
        List<String> resList = new ArrayList<>(len);
        if(arr != null && len > 0){
            for(int i = 0; i < len; i++){
                resList.add(arr[i]);
            }
        }

        return resList;
    }

    public static Double getSum(Double num1, Double num2, String Symbol){
        Double resultNum = 0.0;
        switch (Symbol){
            case "*":
                resultNum = num1 * num2;
                break;
            case "/":
                resultNum = num2 / num1; //注意顺序
                break;
            case "+":
                resultNum =  num1 + num2;
                break;
            case "-":
                resultNum = num2 - num1;
                break;
        }

        return resultNum;
    }
}
