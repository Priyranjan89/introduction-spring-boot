package com.learn.spring.boot.introduction_spring_boot.bakery;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CakeBakerService {

    private final Map<String, Frosting> frostingMap;
    private final Map<String, Syrup> syrupMap;

    public CakeBakerService(Map<String, Frosting> frostingMap, Map<String, Syrup> syrupMap) {
        this.frostingMap = frostingMap;
        this.syrupMap = syrupMap;
    }

    public void makeCake(String cakeType){
        if (!cakeType.isEmpty() && cakeType.equalsIgnoreCase("CHOCOLATE")){
            Frosting chocolateFrosting = frostingMap.get("chocolateFrosting");
            Syrup chocolateSyrup = syrupMap.get("chocolateSyrup");
            System.out.println("Applied "+chocolateFrosting.getFrostingType());
            System.out.println("Applied "+chocolateSyrup.getSyrupType());
            System.out.println("Chocolate Cake is Ready for eat. Enjoy it !!!");
        }

        if (!cakeType.isEmpty() && cakeType.equalsIgnoreCase("STRAWBERRY")){
            Frosting strawberryFrosting = frostingMap.get("strawberryFrosting");
            Syrup strawberrySyrup = syrupMap.get("strawberrySyrup");
            System.out.println("Applied "+strawberryFrosting.getFrostingType());
            System.out.println("Applied "+strawberrySyrup.getSyrupType());
            System.out.println("Strawberry Cake is Ready for eat. Enjoy it !!!");
        }
    }
}
