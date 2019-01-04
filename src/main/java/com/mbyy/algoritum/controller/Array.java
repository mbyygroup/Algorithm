package com.mbyy.algoritum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api("列表:此时参数必须是有序的")
@RestController
@RequestMapping("/Array")
public class Array {

    static int[] getList(int max){
        int[] list=new int[max];
        for (int i = 0; i < max; i++) {
            list[i] = i + 1;
        }
        return list;
    }
    @ApiOperation("进行线性查找")
    @GetMapping(value ="/Linear_ordering" )
    public static String Linear_ordering(){
        int max=100000000;
        int num=max/2+233;
        for (int i:getList(max)){
            if (i==num){
                return "数字"+num+"在第"+i+"位置上";
            }
            i++;
        }
        return "找不到"+num;
    }


}
