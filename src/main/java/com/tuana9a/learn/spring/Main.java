package com.tuana9a.learn.spring;

import com.tuana9a.learn.spring.model.Tyre;
import com.tuana9a.learn.spring.model.Car;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        context.getBeanFactory().registerSingleton("otherCar",new Car());

        Tyre tyre = (Tyre) context.getBean("tyre");
        Car car = (Car) context.getBean("car");
        Car otherCar = (Car) context.getBean("otherCar");

        context.getBeanFactory().destroyBean(car);
        context.getBeanFactory().destroyBean(otherCar);
        context.getBeanFactory().destroyBean(tyre);

        System.out.println("======after destroy=====");

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(context.getBean("otherCar"));
            System.out.println(context.getBean("car"));
        }).start();
    }
}
