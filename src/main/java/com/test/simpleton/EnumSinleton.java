package com.test.simpleton;

/**
 * 枚举 实现 单例
 *
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，
 * 而且还能防止反序列化重新创建新的对象（下面会介绍），可谓是很坚强的壁垒啊，
 * 在深度分析Java的枚举类型—-枚举的线程安全性及序列化问题中有详细介绍枚举的线程安全问题和序列化问题，
 * 不过，个人认为由于1.5中才加入enum特性，用这种方式写不免让人感觉生疏，在实际工作中，我也很少看见有人这么写过，但是不代表他不好。
 */
public enum  EnumSinleton {

    INSTANCE;
    public void EnumSinleton(){

    }

    public static void main(String[] args) {
        EnumSinleton e1 = INSTANCE;
        EnumSinleton e2 = INSTANCE;

        System.out.println(e1 == e2);
    }
}
