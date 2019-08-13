package com.test.simpleton;

/**
 * 懒汉式 加锁
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton singleton;

    private SynchronizedSingleton(){

    }

    /**
     * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的延迟加载，但是，遗憾的是，他效率很低，因为99%情况下不需要同步。
     * （因为上面的synchronized的加锁范围是整个方法，该方法的所有操作都是同步进行的，
     * 但是对于非第一次创建对象的情况，也就是没有进入if语句中的情况，根本不需要同步操作，可以直接返回instance。）
     * @return
     */
    public static synchronized SynchronizedSingleton getInstance(){

        if(singleton == null){
            return  new SynchronizedSingleton();
        }

        return singleton;
    }
}
