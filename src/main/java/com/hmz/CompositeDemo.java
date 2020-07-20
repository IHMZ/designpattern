package com.hmz;

import java.util.ArrayList;
import java.util.List;

public class CompositeDemo {
    public static void main(String[] args) {
        //大学
        University university = new University("清华大学","GOOD");
        //院系
        College collage1 = new College("计算机学院","HOT");
        College collage2 = new College("机械工程学院","COLD");
        //专业
        Department department1 = new Department("网络工程","网络工程");
        Department department2 = new Department("网络安全","网络安全");
        Department department3 = new Department("机电工程","机电工程");
        Department department4 = new Department("自动化","自动化");
        Department department5 = new Department("智能制造","智能制造");

        //专业集合
        List<Organize> collage1s = new ArrayList<>();
        collage1s.add(department1);
        collage1s.add(department2);

        List<Organize> collage2s = new ArrayList<>();
        collage2s.add(department3);
        collage2s.add(department4);
        collage2s.add(department5);

        //学院集合
        List<Organize> universityCollages = new ArrayList<>();
        universityCollages.add(collage1);
        universityCollages.add(collage2);

        //专业集合给到学院 TODO 建议写成add方法，一个一个进行添加
        collage1.setOrganizeList(collage1s);
        collage2.setOrganizeList(collage2s);

        //学院集合给到学校 TODO 建议写成add方法，一个一个进行添加
        university.setOrganizeList(universityCollages);

        university.print();

    }
}

/**
 * 抽象组织类
 */
abstract class Organize{

    private String name;
    private String descriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    protected void add(Organize organize){
        throw new UnsupportedOperationException();
    }

    protected void remove(Organize organize){
        throw new UnsupportedOperationException();
    }

    public Organize(String name, String descriptions) {
        this.name = name;
        this.descriptions = descriptions;
    }

    abstract protected void print();
}

/**
 * 学校
 */
class University extends Organize{

    private List<Organize> organizeList;

    public University(String name, String descriptions) {
        super(name, descriptions);
    }

    public List<Organize> getOrganizeList() {
        return organizeList;
    }

    public void setOrganizeList(List<Organize> organizeList) {
        this.organizeList = organizeList;
    }

    @Override
    protected void print() {
        System.out.println("------" + getName() + "------");
        for (Organize organize : organizeList) {
            organize.print();
        };
    }


}

/**
 * 院系
 */
class College extends Organize{

    private List<Organize> organizeList;

    public College(String name, String descriptions) {
        super(name, descriptions);
    }

    public List<Organize> getOrganizeList() {
        return organizeList;
    }

    public void setOrganizeList(List<Organize> organizeList) {
        this.organizeList = organizeList;
    }

    @Override
    protected void print() {
        System.out.println("------" + getName() + "------");
        for (Organize organize : organizeList) {
            System.out.println(organize.getName());
        }
    }


}

/**
 * 专业
 */
class Department extends Organize{

    public Department(String name, String descriptions) {
        super(name, descriptions);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }


}
