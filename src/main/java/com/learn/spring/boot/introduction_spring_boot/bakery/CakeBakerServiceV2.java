package com.learn.spring.boot.introduction_spring_boot.bakery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeBakerServiceV2 {

    private final List<CakeHandler> cakeHandlers;

    public CakeBakerServiceV2(List<CakeHandler> cakeHandlers) {
        this.cakeHandlers = cakeHandlers;
    }

    public void makeCake(String cakeType){
        for (CakeHandler cakeHandler : cakeHandlers){
            if (cakeHandler.canHandle(cakeType)){
                cakeHandler.makeTheCake();
            }
        }
    }
}
