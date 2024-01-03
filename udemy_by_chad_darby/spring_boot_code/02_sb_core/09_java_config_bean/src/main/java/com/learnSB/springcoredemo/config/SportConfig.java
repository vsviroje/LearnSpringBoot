package com.learnSB.springcoredemo.config;

import com.learnSB.springcoredemo.common.Coach;
import com.learnSB.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //eg for java config bean
public class SportConfig {
    @Bean //so bean id is method name or custom id can be assigned ie @Bean("anyName") ...this has to be used in @Qualifier
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
