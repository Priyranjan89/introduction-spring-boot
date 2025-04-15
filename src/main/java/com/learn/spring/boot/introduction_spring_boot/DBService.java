package com.learn.spring.boot.introduction_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    final private DB db;

    //@Autowired
    public DBService(DB db) {
        this.db = db;
    }
    String getData() {
        return db.getData();
    }

}
