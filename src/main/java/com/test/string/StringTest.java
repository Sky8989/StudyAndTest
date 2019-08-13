package com.test.string;

public class StringTest {

    /**
     * new String 所谓的“如果有的话就直接引用”，指的是Java堆中创建的String对象中包含的字符串字面量直接引用字符串池中的字面量对象。
     * 也就是说，还是要在堆里面创建对象的;
     * 而intern中说的“如果有的话就直接返回其引用”，指的是会把字面量对象的引用直接返回给定义的对象。这个过程是不会在Java堆中再创建一个String对象的。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "aaa";      //直接在常量池 创建
        String s2 = new String("aaa");   //先在堆中创建对象  如果在常量池中 存在字符串 引用
        /**
         * JVM会查找常量池中是否有相同Unicode的字符串常量，
         * 如果有，则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用；
         * 注意: 和 new String()的区别: 不会去堆中创建对象
         */
        String s3 = new String("aaa").intern();
        String s4 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s4);

        System.out.println("==========");

        /**
         * 先在 堆中创建引用对象  再去常量池 增加一个Unicode等于str的字符串并返回它的引用
         */
        String s5 = new String("ccc");
        /**
         * 因为存在 字符串常量 直接去常量池 引用
         */
        String s6 = new String("ccc").intern();
        //直接去 常量池 引用
        String s7 = "ccc";

        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
    }
}
