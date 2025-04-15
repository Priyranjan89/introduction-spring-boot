package com.learn.spring.boot.introduction_spring_boot.bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolatesyrup")
public class ChocolateSyrup implements  Syrup{
    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}
