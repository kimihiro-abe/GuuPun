package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EnvChecker {

    @Value("${DB_URL:NotFound}")
    private String dbUrl;

    @PostConstruct
    public void checkEnv() {
        System.out.println(">>> DB_URL = " + dbUrl);
    }
}
