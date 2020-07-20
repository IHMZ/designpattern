package com.hmz;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.image.MemoryImageSource;

/**
 * 桥接模式 品牌类（接口）+ 各个不同的品牌厂家
 *        产品类（抽象） + 各个不同类型的实现
 *        增加品牌，或者增加不同的抽象都可以完场全部产品的增加
 */
public class BridgeDemo {
    public static void main(String[] args) {

        Brand mi = new Mi();
        AndroidPhone androidPhone = new AndroidPhone(mi);
        androidPhone.open();
        androidPhone.close();

       AndroidPhone newBrand = new AndroidPhone(new Brand() {
            @Override
            public void open() {
                System.out.println("NEW BRAND OPEN");
            }

            @Override
            public void close() {
                System.out.println("NEW BRAND CLOSE");
            }
        });
       newBrand.open();
       newBrand.close();


       Phone newPhone = new Phone(mi) {
           @Override
           protected void close() {
               super.close();
               System.out.println("WP CLOSE");
           }

           @Override
           protected void open() {
               super.open();
               System.out.println("WP OPEN");
           }
       };
       newPhone.open();
       newPhone.close();
    }

}


/**
 * 品牌类
 */
interface Brand{

    void open();

    void close();
}

/**
 * 品牌实现类
 */
class Mi implements Brand{

    @Override
    public void open() {
        System.out.println("MI OPEN");
    }

    @Override
    public void close() {
        System.out.println("MI CLOSE");
    }
}

/**
 * 抽象产品类
 */
abstract class Phone{

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void close(){
        brand.close();
    }

    protected void open(){
        brand.open();
    }
}

/**
 * 具体产品实现类
 */
class AndroidPhone extends Phone{

    public AndroidPhone(Brand brand) {
        super(brand);
    }

    public void close(){
        System.out.println("Android Close");
        super.close();
    }

    public void open(){
        System.out.println("Android Open");
        super.open();
    }

}