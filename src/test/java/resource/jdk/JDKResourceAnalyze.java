package resource.jdk;

import com.mysql.cj.conf.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;
import resource.spring.HandlerAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JDKResourceAnalyze {

    public static void main(String[] args) throws IOException {

        /**
         * 单例模式 饿汉式
         */
        Runtime runtime = Runtime.getRuntime();

        /**
         * 简单工厂模式
         */
        Calendar instance = Calendar.getInstance();

        /**
         * 建造者模式
         */
        StringBuilder stringBuilder = new StringBuilder().append('a');

        /**
         * 桥接模式
         */
        try {
            Connection connection = new ConnectionImpl(new HostInfo());
            Driver driver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /**
         * 装饰者模式
         */
        FileInputStream fileInputStream = new FileInputStream("D:/text.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        /**
         * 组合模式
         */
        Map hashmap = new HashMap();
        hashmap.put("AA","BB");
        Map hashmap2 = new HashMap();
        hashmap2.put("cc","dd");
        hashmap2.put("ee","ff");
        hashmap.putAll(hashmap2);

        /**
         * 享元模式
         */
        Integer i = Integer.valueOf(11);

    }
}
