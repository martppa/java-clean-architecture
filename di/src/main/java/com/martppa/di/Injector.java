package com.martppa.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Injector {
    private static Injector instance;

    private ApplicationContext applicationContext;

    static {
        instance = new Injector();
    }

    protected Injector() {

    }

    protected void build(String configPath) {
        applicationContext = new ClassPathXmlApplicationContext(configPath);
    }

    public static Injector getInstance() {
        return instance;
    }

    public <T> T inject(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
