package com.learnSB.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //  indicates that a particular bean should be given preference when multiple beans are candidates to be autowired to a single-valued dependency ie for Coach interface
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "tennis practice for 10 min!!";
    }
}
