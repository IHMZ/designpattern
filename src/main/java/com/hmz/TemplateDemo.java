package com.hmz;

/**
 * 模板模式
 */
public class TemplateDemo {
    public static void main(String[] args) {

        RedBeanSoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();

        System.out.println("--------------------");

        PureSoyMilk pureSoyMilk = new PureSoyMilk();
        pureSoyMilk.make();
    }
}

/**
 * 抽象模板类
 */
abstract class SoyMilk{
    public final void make(){
        prepare();
        if (ifAdd()){
            add(); //钩子方法
        }
        beat();
    }
    public void prepare(){
        System.out.println("准备黄豆");
    }
    abstract public void add();

    public void beat(){
        System.out.println("制作豆浆");
    }

    public boolean ifAdd(){
        return true;
    }
}

/**
 * 具体实现类
 */
class RedBeanSoyMilk extends SoyMilk{
    @Override
    public void add() {
        System.out.println("添加红豆");
    }
}

/**
 * 具体实现类
 */
class PureSoyMilk extends SoyMilk{

    @Override
    public void add() {

    }
    @Override
    public boolean ifAdd() {
        return false;
    }
}
