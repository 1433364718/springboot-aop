package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping
    public String Test(){
        System.out.println("目标类");
        return "aaaaaa";
    }
}
