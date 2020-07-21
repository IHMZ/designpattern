package com.hmz;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class JDKProxyDemo {
    public static void main(String[] args) {

        ITeacher tomProxy = (ITeacher)
                new TeacherProxyFactory(new Teacher("tom")).getProxyInstance();
        tomProxy.teach();
    }
}

/**
 * 代理工厂
 */
class TeacherProxyFactory{

    private ITeacher target;

    public TeacherProxyFactory(ITeacher target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理开始");
                        Object result = method.invoke(target, args);
                        System.out.println("代理结束");
                        return result;
                    }
                });
    }
}

/**
 * 被代理类
 */
class Teacher implements ITeacher{

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void teach() {
        System.out.println(name + "老师开始讲课了");
    }
}

/**
 * 目标对象实现的接口类
 */
interface ITeacher{
    void teach();
}
