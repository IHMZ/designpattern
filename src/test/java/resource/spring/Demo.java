package resource.spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class Demo {
    public static void main(String[] args) {


        /**
         * 模板方法
         * ConfigurableApplicationContext 接口
         * AbstractApplicationContext 抽象类实现接口 refresh 模板方法
         * GenericApplicationContext 继承抽象类 对模板方法的钩子方法进行具体的实现
         */

        JdbcTemplate jdbcTemplate = new JdbcTemplate();


    }
}
