package com.example.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "HellowContorller", description = "controller描述测试")
//@Api(value = "controller描述测试")
@RequestMapping(value = "/first")
@RestController
public class hellow {
    @GetMapping(value = "/hello")
    /* 方法注解 */
    @ApiOperation(value = "方法描述测试", notes = "")

    public String helloWord() {
        var a = "aaa";
        return a;
    }

}


