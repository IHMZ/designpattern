package com.hmz;

import java.util.LinkedList;
import java.util.List;

public class VisitorDemo {
    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure();
        Man man = new Man();
        Woman woman = new Woman();

        objectStructure.attach(man);
        objectStructure.attach(woman);

        /**
         * TODO 有问题 只能展示一种评价
         */
        objectStructure.display(new Fail());

    }
}

class ObjectStructure{
    //维护了一个集合
    private List<Person> persons = new LinkedList<>();
    //增加到list
    public void attach(Person p) {
        persons.add(p);
    }
    //移除
    public void detach(Person p) {
        persons.remove(p);
    }

    //显示测评情况
    public void display(Action action) {
        for(Person p: persons) {
            p.accept(action);
        }
    }
}

abstract class Action{

    //得到男性 的测评
    public abstract void getManResult(Man man);

    //得到女的 测评
    public abstract void getWomanResult(Woman woman);
}

class Success extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价该歌手成功 !");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价该歌手成功 !");
    }
}

class Fail extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价该歌手失败 !");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价该歌手失败 !");
    }
}

abstract class Person{

    //提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}

class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}

class Woman extends Person{

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}