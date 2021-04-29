package com.example.demo.controller;

import org.thymeleaf.spring5.processor.SpringActionTagProcessor;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
