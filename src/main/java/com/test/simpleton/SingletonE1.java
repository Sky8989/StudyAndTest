package com.test.simpleton;

/**
 * 饿汉式 另一种
 *
 *  饿汉式单例，在类被加载的时候对象就会实例化。这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。
 *  而且，如果这个类被多次加载的话也会造成多次实例化。其实解决这个问题的方式有很多，
 *  下面提供两种解决方式，第一种是使用静态内部类的形式。第二种是使用懒汉式。
 */
public class SingletonE1 {

    /**
     * 在类内部实例化一个实例
     */
    private static SingletonE1 SINGLETON_E;

    static{
        SINGLETON_E = new SingletonE1();
    }

    /**
     * 私有的构造函数
     */
    private SingletonE1(){

    }

    /**
     * 对外提供获取实例的静态方法
     * @return
     */
    public static SingletonE1 getInstance(){
        return SINGLETON_E;
    }


    public static void main(String[] args) {
        SingletonE1 s1 = SingletonE1.getInstance();
        SingletonE1 s2 = SingletonE1.getInstance();
        System.out.println(s1 == s2);
    }
}
