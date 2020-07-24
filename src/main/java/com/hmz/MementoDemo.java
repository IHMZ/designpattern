package com.hmz;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式，讲状态保存至一个备忘录中，需要的时候再从备忘录中取出
 */
public class MementoDemo {
    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" 状态#1 攻击力 100 ");

        //保存了当前的状态
        caretaker.add(originator.saveStateMemento());

        originator.setState(" 状态#2 攻击力 80 ");

        caretaker.add(originator.saveStateMemento());

        originator.setState(" 状态#3 攻击力 50 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是 =" + originator.getState());

        //希望得到状态 1, 将 originator 恢复到状态1

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("恢复到状态1 , 当前的状态是");
        System.out.println("当前的状态是 =" + originator.getState());
    }
}

/**
 * 对象类
 */
class Originator {

    private String state;//状态信息

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //编写一个方法，可以保存一个状态对象 Memento
    //因此编写一个方法，返回 Memento
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    //通过备忘录对象，恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

/**
 * 备忘录类
 */
class Memento {
    private String state;

    //构造器
    public Memento(String state) {
        super();
        this.state = state;
    }

    public String getState() {
        return state;
    }



}

class Caretaker {

    //在List 集合中会有很多的备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取到第index个Originator 的 备忘录对象(即保存状态)
    public Memento get(int index) {
        return mementoList.get(index);
    }
}