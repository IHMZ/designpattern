package com.hmz;

import java.util.HashMap;

/**
 * 享元模式 对象可以复用 单例工厂，创建并存储多个对象
 */
public class FlyweightDemo {
    public static void main(String[] args) {

        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite news = webSiteFactory.getWebSite("新闻");
        WebSite blob = webSiteFactory.getWebSite("博客");
        WebSite blob2 = webSiteFactory.getWebSite("博客");
        news.use(new User("tom"));
        blob.use(new User("jack"));
        blob2.use(new User("jenny"));
        System.out.println(webSiteFactory.getTotal());
    }
}

/**
 * 抽象对象
 */
abstract class WebSite{
    protected abstract void use(User user);
}

/**
 * 具体对象
 */
class DoWebSite extends WebSite{

    private String type; //内部依赖

    public DoWebSite(String type) {
        this.type = type;
    }

    @Override
    protected void use(User user) {
        System.out.println(user.getName() + "正在使用"+ type +"类型的网站：" );

    }
}

/**
 * 外部依赖
 */
class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 对象工厂
 */
class WebSiteFactory{

    private HashMap<String,WebSite> websitePool = new HashMap<>();

    public WebSite getWebSite(String type){
        if (!websitePool.containsKey(type)){
            websitePool.put(type,new DoWebSite(type));
        }
        return websitePool.get(type);
    }

    public Integer getTotal(){return websitePool.size();}
}
