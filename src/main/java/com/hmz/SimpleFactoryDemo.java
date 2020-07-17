package com.hmz;

/**
 * 简单工厂模式 增加产品，需要增加茶品类，继承并实现抽象产品类的方法即可在工厂进行生产
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Order.orderPizza(GreekPizza.class);
        Order.orderPizza(CheesePizza.class);
    }
}

/**
 * 订单类 调用工厂类
 */
class Order{
    public static void orderPizza(Class pizzaType){
        SimpleFactory.createPizza(pizzaType);
    }
}

/**
 * 工厂类 生产产品
 */
class SimpleFactory{
    public static void createPizza(Class clazz) {
        try {
            Pizza pizza =(Pizza) clazz.getConstructor().newInstance();
            clazz.getDeclaredMethod("prepare").invoke(pizza);
            clazz.getDeclaredMethod("bake").invoke(pizza);
            clazz.getDeclaredMethod("cut").invoke(pizza);
            pizza = (Pizza)clazz.getDeclaredMethod("box").invoke(pizza);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 抽象产品类
 */
abstract class Pizza{

    public  abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract Pizza box();
}

/**
 * 具体产品类
 */
class GreekPizza extends Pizza{

    public static final String NAME = "GreekPizza";

    public GreekPizza() {
    }

    @Override
    public void prepare() {
        System.out.println("准备" + NAME);
    }

    @Override
    public void bake() {
        System.out.println("烘培" + NAME);
    }

    @Override
    public void cut() {
        System.out.println("切割" + NAME);

    }

    @Override
    public Pizza box() {
        System.out.println("打包" + NAME);
        return new GreekPizza();
    }
}

/**
 * 具体产品类
 */
class CheesePizza extends Pizza{

    public static final String NAME = "CheesePizza";
    public CheesePizza() {
    }

    @Override
    public void prepare() {
        System.out.println("准备" + NAME);
    }

    @Override
    public void bake() {
        System.out.println("烘培" + NAME);
    }

    @Override
    public void cut() {
        System.out.println("切割" + NAME);
    }

    @Override
    public Pizza box() {
        System.out.println("打包" + NAME);
        return new CheesePizza();
    }
}
