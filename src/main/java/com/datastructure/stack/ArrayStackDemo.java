package com.datastructure.stack;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStackDemo {


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

//        System.out.println("请输入需要计算的字符");
//        Scanner sc = new Scanner(System.in);
//        String key = sc.next();
        String key = "13-4+2";

        Double result =  calculation(key.trim());
        System.out.println("运算符 = " + key);
        System.out.println("结果 = " + result);
    }

    /**
     * 计算
     * @param key
     * @return
     */
    private static Double calculation(String key) {
        Double result = 0.0;

        if(StringUtils.isEmpty(key)){
            throw new RuntimeException("传入参数为空");
        }

        ArrayStack stackNumber = new ArrayStack(5);
        ArrayStack stackCal = new ArrayStack(5);

        String mulStr = "";

        int len = key.length();
        for(int i = 0; i < len; i++){
           String val = key.charAt(i)+"";
           //判断是否为数字
           if(!isSymbol(val)){
               //数字
               //stackNumber.push(Double.parseDouble(val));

               //判断是否为多位数
               mulStr += val;
               //防止越界
               if(i+1 == len){
                   break;
               }

               //往后看一位是否为数字
               if(isSymbol(key.charAt(i+1)+"")) {
                   //后一位如果是符合 直接压入栈中
                   stackNumber.push(Double.parseDouble(mulStr));
                   //重置
                   mulStr = "";
               }

           }else{
               //为运算符
               if(stackCal.isEmpty()){
                   //栈为空 直接加入
                   stackCal.push(val);
               }else{
                   //栈不为空 比较大小
                   if(stackCal.priority(val) <= stackCal.priority((String) stackCal.peek())){
                       //当前运算符的优先级 小于等于 出栈 运算符的优先级
                       //取出两个数字进行计算
                       Double num1 = (Double) stackNumber.pop();
                       Double num2 = (Double) stackNumber.pop();
                       String symbol = (String) stackCal.pop();

                       Double resultNum = 0.0;
                       resultNum = getSum(num1,num2,symbol);

                       //将计算结果 加入栈中
                       stackNumber.push(resultNum);
                       stackCal.push(val);
                   }else{
                       //直接加入栈中
                       stackCal.push(val);


                   }
               }
           }

        }
//        System.out.println("stackCal" );
//        stackCal.list();
//        System.out.println("stackNumber" );
//        stackNumber.list();

        Double resultNum = 0.0;
        //循环进行 + - 操作
        while(true){

               String operator = (String) stackCal.pop();
               Double num1 = Double.parseDouble(stackNumber.pop().toString());
               Double num2 = Double.parseDouble(stackNumber.pop().toString());

                resultNum += getSum(num1,num2,operator);

                if(stackCal.size()  == 0){
                    stackNumber.push(resultNum);
                    break;
                }
        }
        return (Double) stackNumber.pop();
    }

    private static boolean isSymbol(String val) {
        return "+".equals(val) || "-".equals(val) || "*".equals(val) || "/".equals(val);
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


    static class ArrayStack{
        Object[] elementData;

        int size;

        int top = -1;


        public ArrayStack(int size) {
            this.size = size;
            elementData = new Object[this.size];
        }


        public Object getIndex(int index){
            if(index < 0 || top < index ){
                System.out.println("数组越界");
                return 0;
            }

            return elementData[index];
        }

        /**
         * 入栈
         * @param newNum
         */
        public void push(Object newNum){

            if(top + 1 == elementData.length){
                elementData = Arrays.copyOf(elementData,elementData.length+1);
                this.size = elementData.length;
            }

            elementData[++top] = newNum;

        }

        /**
         * 出栈
         * @return
         */
        public Object pop(){
            int len = size();
            if(len == 0){
                System.out.println("栈为空");
                return 0;
            }

            Object result = elementData[top];
            elementData[top--] = null;
            return  result;
        }

        /**
         *
         * @return
         */
        public int size(){

            return top+1;
        }

        public boolean isEmpty(){
            return -1 == top;
        }


        public void list(){
            if(isEmpty()){
                throw new RuntimeException("栈为空");
            }

            for(int i = 0; i <= this.top; i++){
                System.out.println("[" + i + "] = " + elementData[i]);
            }

        }


        private int priority(String val) {

            if ("/".equals(val.trim()) || "*".equals(val.trim())) {
                return 1;
            } else if ("+".equals(val.trim()) || "-".equals(val.trim() )) {
                return 0;
            }
            return -1;
        }

        public Object peek(){
            return elementData[top];
        }
    }
}
