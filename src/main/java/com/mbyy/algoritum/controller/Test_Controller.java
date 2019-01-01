package com.mbyy.algoritum.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试")
@RestController
@RequestMapping("/")
public class Test_Controller {
    public static final int math=3;

    @GetMapping("test")
    public String test(){
        return "Hello"+math;
    }
}

