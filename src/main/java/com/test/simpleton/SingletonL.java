package com.test.simpleton;

/**
 * 懒汉式
 */
public class SingletonL {

    private static SingletonL singletonL;

    private  SingletonL(){

    }

    /**
     * 有没有发现，其实这种懒汉式单例其实还存在一个问题，那就是线程安全问题。
     * 在多线程情况下，有可能两个线程同时进入if语句中，这样，
     * 在两个线程都从if中退出的时候就创建了两个不一样的对象。（这里就不详细讲解了，不理解的请恶补多线程知识）。
     * @return
     */
    public static SingletonL getInstance(){

        if(singletonL == null){
            return  new SingletonL();
        }

        return singletonL;
    }
}
