package com.hmz;

public class Singleton {
    public static void main(String[] args) {

    }
}

/**
 * 饿汉式 静态变量
 */
class Singleton1{
    private Singleton1(){};

    private static final Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }
}

/**
 * 饿汉式 静态代码块
 */
class Singleton2{
    private Singleton2(){}

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return instance;
    }
}

/**
 * 懒汉式  线程不安全
 */
class Singleton3{

    private Singleton3(){}

    private static Singleton3 instance;

    public static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * 懒汉式  方法加同步锁
 */
class Singleton4{

    private Singleton4(){}

    private static Singleton4 instance;

    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}

/**
 * 懒汉式  双重检查
 */
class Singleton5{

    private Singleton5(){}

    /**
     * volatile
     * 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     * 禁止进行指令重排序。（实现有序性）
     * volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性
     */
    private static volatile Singleton5 instance;

    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

/**
 * 枚举类
 */
enum Singleton6{
    INSTANCE;
}

/**
 * 内部类
 */
class Singleton7{

    private Singleton7(){}

    private static class InnerSingleton7{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return InnerSingleton7.INSTANCE;
    }
}