package com.hmz;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 代理
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        CgTeacher proxyInstance = (CgTeacher) new FactoryProxy(new CgTeacher("tom")).getProxyInstance();
        proxyInstance.teach();
    }
}

/**
 * cglib代理工厂 实现 MethodInterceptor
 */
class FactoryProxy implements MethodInterceptor{

    private Object target;

    public FactoryProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create(); //被代理类需要无参构造器
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB 代理开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("CGLIB 代理结束");
        return invoke;
    }
}

/**
 * 被代理的目标对象
 */
class CgTeacher{
    private String name;

    public CgTeacher(String name) {
        this.name = name;
    }

    public CgTeacher() {
    }

    public void teach(){
        System.out.println(name + "开始讲课");
    }
}
