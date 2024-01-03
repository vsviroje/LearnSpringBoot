package com.learnSB.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In Constructor:" + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkOut() {
        return "Practice for 15 min!!!";
    }
}

