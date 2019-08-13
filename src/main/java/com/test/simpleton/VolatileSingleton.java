package com.test.simpleton;

/**
 * 使用 volatile 解决 双重校验锁可能出现的问题
 *
 */
public class VolatileSingleton {

    private static volatile VolatileSingleton singleton;

    private VolatileSingleton(){

    }

    /**
     * 下面这种双重校验锁的方式用的比较广泛，他解决了前面提到的所有问题。
     * 但是，即使是这种看上去完美无缺的方式也可能存在问题，那就是遇到序列化的时候。详细内容后文介绍
     * @return
     */
    public static VolatileSingleton getInstance(){
        if(singleton == null){
            synchronized (VolatileSingleton.class){
                if(singleton == null){
                    singleton = new VolatileSingleton();
                }
            }
        }

        return singleton;
    }
}
