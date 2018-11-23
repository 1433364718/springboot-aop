package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @RequestMapping("/test")
    public String Test(){
        System.out.println("目标类");
        return "aaaaaa";
    }
}
