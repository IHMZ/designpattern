package com.hmz;

import java.util.ArrayList;

/**
 * 观察者模式 通知所有观察者接受更新
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherObserver weatherObserver = new WeatherObserver();
        WeatherSubject weatherSubject = new WeatherSubject();
        weatherSubject.register(weatherObserver);
        weatherSubject.update(27f,16f, 46f);

    }
}

/**
 * 观察者接口
 */
interface Observer{
    void update(float temperature,float humidity,float pressure);
}

/**
 * 分发者接口
 */
interface Subject{
    void register(Observer observer);
    void remove(Observer observer);
    void notifyObserver();
}

/**
 * 分发者实现
 */
class WeatherSubject implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList<Observer> observers;

    public WeatherSubject() {
        observers = new ArrayList<>();
    }

    public void update(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature,humidity,pressure);
        }
    }
}

/**
 * 观察者实现
 */
class WeatherObserver implements Observer{

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature,float humidity,float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    public void display(){
        System.out.println("WeatherObserver");
        System.out.println("temperature=" + temperature);
        System.out.println("humidity=" + humidity);
        System.out.println("pressure=" + pressure);
    }
}
