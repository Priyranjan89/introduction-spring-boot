package com.learn.spring.boot.introduction_spring_boot.bakery;

public interface CakeHandler {

    public boolean canHandle(String cakeType);

    public void makeTheCake();
}
