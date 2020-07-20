package com.hmz;

import com.sun.org.apache.bcel.internal.generic.DREM;
import sun.util.resources.cldr.es.CalendarData_es_PY;

import java.math.BigDecimal;

public class DecoratorDemo {
    public static void main(String[] args) {

        /**
         * 主题只能有一个
         */
        Drink drink = new BlackCoffee();

        /**
         * 对其进行装饰
         */
        drink = new Milk(drink);
        drink = new Milk(drink);

        System.out.println(drink.sumDescription());
        System.out.println(drink.sumCost());

    }
}

/**
 * 总类
 */
abstract class Drink{

    private String description;

    private BigDecimal cost;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public abstract BigDecimal sumCost();

    public abstract String sumDescription();
}



/**
 * 主体总类
 */
class Coffee extends Drink{
    @Override
    public BigDecimal sumCost() {
        return super.getCost();
    }

    @Override
    public String sumDescription() {
        return super.getDescription() + ":" + super.getCost() + "元";
    }
}

/**
 * 主体类分类
 */
class BlackCoffee extends Coffee{
    public BlackCoffee() {
        setCost(new BigDecimal(5));
        setDescription("黑咖啡");
    }
}


/**
 * 装饰总类
 */
class Flavour extends Drink{

    private Drink drink; //装饰后本身也是一个饮料

    public Flavour(Drink drink) {
        this.drink = drink;
    }

    @Override
    public BigDecimal sumCost() {
        return super.getCost().add(drink.sumCost());
    }

    @Override
    public String sumDescription() {
        return drink.sumDescription() + "\t" + getDescription() + ":" + getCost() +"元\t";
    }


}

/**
 * 具体装饰类
 */
class Milk extends Flavour{

    public Milk(Drink drink) {
        super(drink);
        setDescription("牛奶");
        setCost(new BigDecimal(2));
    }

    @Override
    public String sumDescription() {
        return super.sumDescription();
    }

}
