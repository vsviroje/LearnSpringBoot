package com.learnSB.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Baseball practice for 30 min!!!";
    }
}
