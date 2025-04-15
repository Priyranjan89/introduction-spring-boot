package com.learn.spring.boot.introduction_spring_boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = " ")
public class DevDB implements DB {

    public String getData() {
        return "Dev Data";
    }

}
