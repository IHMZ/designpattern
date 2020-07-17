package com.hmz;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;


public class PrototypeDemo {
    public static void main(String[] args) {
        Book book = new Book("西游记", "吴承恩");
        Object clone = book.clone();
        System.out.println(clone);
        System.out.println(book);
        System.out.println(book == clone);

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");
        Object bookXML = applicationContext.getBean("book");
        Object bookXML2 = applicationContext.getBean("book");

        System.out.println(bookXML);
        System.out.println(bookXML2);
        System.out.println(bookXML == bookXML2);

        Boy boy = new Boy("小明");
        boy.setFriend(new Boy("小红"));
        Boy boy1 = boy.deepClone();
        System.out.println(boy.getFriend());
        System.out.println(boy1.getFriend());

        Boy boy2 = boy.deepCloneByIO();
        System.out.println(boy2.getFriend());


    }
}

/**
 * 浅拷贝 基本数据类型会直接拷贝，引用数据类型不会进行赋值，仅指向对象地址
 */
class Book implements Cloneable{
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Book book = null;
        try {
            book = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;
    }

}

class Boy implements Cloneable,Serializable{
    private String name;
    private Boy friend;

    public Boy(String name) {
        this.name = name;
    }

    public void setFriend(Boy friend) {
        this.friend = friend;
    }

    public Boy getFriend() {
        return friend;
    }

    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boy deepClone(){
        Boy boy = (Boy) this.clone(); //克隆非引用类
        boy.friend = (Boy) friend.clone(); //克隆引用类
        return boy;
    }

    public Boy deepCloneByIO(){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Boy clone = (Boy)ois.readObject();

            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}