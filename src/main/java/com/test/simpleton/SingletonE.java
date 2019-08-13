package com.test.simpleton;

/**
 * 饿汉式
 *
 * 饿汉式单例，在类被加载的时候对象就会实例化。这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。
 * 而且，如果这个类被多次加载的话也会造成多次实例化。
 * 其实解决这个问题的方式有很多，下面提供两种解决方式，
 * 第一种是使用静态内部类的形式。第二种是使用懒汉式。
 */
public class SingletonE {

    /**
     * 在类内部实例化一个实例
     */
    private static  SingletonE SINGLETON_E = new SingletonE();

    /**
     * 私有的构造函数
     */
    private SingletonE(){

    }

    /**
     * 对外提供获取实例的静态方法
     * @return
     */
    public static SingletonE getInstance(){
        return SINGLETON_E;
    }


    public static void main(String[] args) {
        SingletonE s1 = SingletonE.getInstance();
        SingletonE s2 = SingletonE.getInstance();
        System.out.println(s1 == s2);
    }
}
