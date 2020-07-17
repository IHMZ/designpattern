package resource.jdk;

import java.util.Calendar;

public class JDKResourceAnalyze {

    public static void main(String[] args) {

        /**
         * 单例模式 饿汉式
         */
        Runtime runtime = Runtime.getRuntime();

        /**
         * 简单工厂模式
         */
        Calendar instance = Calendar.getInstance();
    }
}
