package com.learnSB.springcoredemo.rest;

import com.learnSB.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myTheCoach, @Qualifier("cricketCoach") Coach myTheAnotherCoach) {
        System.out.println("In Constructor:" + getClass().getSimpleName());
        myCoach = myTheCoach;
        myAnotherCoach = myTheAnotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Bean Scope myCoach==myAnotherCoach : " + (myCoach == myAnotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut() {
        return myCoach.getDailyWorkOut();
    }
}
