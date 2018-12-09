package com.mbyy.algoritum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Test_Controller {
    public static final int math=3;

    @GetMapping("test")
    public String test(){
        return "Hello"+math;
    }
}

