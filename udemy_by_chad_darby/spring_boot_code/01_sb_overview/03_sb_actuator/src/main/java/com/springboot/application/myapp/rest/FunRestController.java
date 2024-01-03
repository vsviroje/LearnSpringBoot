package com.springboot.application.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose "/workout" that return "walk 5k"
    @GetMapping("/workout")
    public String workout(){
        return "walk 5k";
    }
}
