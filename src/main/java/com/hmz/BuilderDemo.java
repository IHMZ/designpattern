package com.hmz;

/**
 * 建造者模式 若要建造出不同的产品，则需增加新的具体建造者，
 * 指挥者，指挥该建造者，即可建造出新的产品
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new CommonBuilder());
        House house = director.create();
        House house2 = director.create();

        System.out.println(house);
        System.out.println(house == house2);
        System.out.println(house2);
    }
}

/**
 * 指挥者
 */
class Director{
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public House create(){
        builder.build();
        return builder.getHouse();
    }
}

/**
 * 具体建造者
 */
class CommonBuilder extends Builder{

    @Override
    public void buildBase() {
        house.setBase(2);
    }

    @Override
    public void buildWall() {
        house.setWall(2);
    }

    @Override
    public void buildRoof() {
        house.setRoof(2);
    }

    public House getHouse() {
        return house;
    }
}

/**
 * 抽象建造者
 */
abstract class Builder{

    public House house;

    public abstract void buildBase();
    public abstract void buildWall();
    public abstract void buildRoof();

    public void build(){
        house = new House();
        buildBase();
        buildWall();
        buildRoof();
    }

    public abstract House getHouse();
}

/**
 * 产品类
 */
class House{
    private Integer base;
    private Integer wall;
    private Integer roof;

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getWall() {
        return wall;
    }

    public void setWall(Integer wall) {
        this.wall = wall;
    }

    public Integer getRoof() {
        return roof;
    }

    public void setRoof(Integer roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "base=" + base +
                ", wall=" + wall +
                ", roof=" + roof +
                '}';
    }
}