package com.learn.spring.boot.introduction_spring_boot.bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChocolateCakeHandler implements CakeHandler{

    private ChocolateFrosting chocolateFrosting;

    private ChocolateSyrup chocolateSyrup;

    public ChocolateCakeHandler(@Qualifier("chocolatefrosting") ChocolateFrosting chocolateFrosting,
                                @Qualifier("chocolatesyrup") ChocolateSyrup chocolateSyrup) {
        this.chocolateFrosting = chocolateFrosting;
        this.chocolateSyrup = chocolateSyrup;
    }

    @Override
    public boolean canHandle(String cakeType) {
        return cakeType.equalsIgnoreCase("CHOCOLATE");
    }

    @Override
    public void makeTheCake() {
        System.out.println("Applied "+chocolateFrosting.getFrostingType());
        System.out.println("Applied "+chocolateSyrup.getSyrupType());
        System.out.println("Chocolate Cake is Ready for eat. Enjoy it !!!");
    }
}
