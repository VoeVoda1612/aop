package edu.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        APIComponent apiComponent = (APIComponent) context.getBean("anyComponent");
        APIService apiService = (APIService) context.getBean("anyService");

        apiComponent.executeMethod("Hello World", 1488, new Object());
        apiService.executeMethodService("Hello World", 1488, new Object());

    }
}
