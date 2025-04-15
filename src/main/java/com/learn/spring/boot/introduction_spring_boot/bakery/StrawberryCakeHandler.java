package com.learn.spring.boot.introduction_spring_boot.bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StrawberryCakeHandler implements CakeHandler{

    private StrawberryFrosting strawberryFrosting;
    private StrawberrySyrup strawberrySyrup;

    public StrawberryCakeHandler(@Qualifier("strawberryfrosting") StrawberryFrosting strawberryFrosting,
                                 @Qualifier("strawberrysyrup") StrawberrySyrup strawberrySyrup) {
        this.strawberryFrosting = strawberryFrosting;
        this.strawberrySyrup = strawberrySyrup;
    }

    @Override
    public boolean canHandle(String cakeType) {
        return cakeType.equalsIgnoreCase("STRAWBERRY");
    }

    @Override
    public void makeTheCake() {
        System.out.println("Applied "+strawberryFrosting.getFrostingType());
        System.out.println("Applied "+strawberrySyrup.getSyrupType());
        System.out.println("Strawberry Cake is Ready for eat. Enjoy it !!!");
    }
}
