package com.example.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "我是firstController")
@RequestMapping(value = "/first")
@RestController
public class hellow {
    @GetMapping(value = "/hello")
    /* 方法注解 */
    @ApiOperation(value = "我是hello方法", notes = "")

    public String helloWord(){
        var a = "aaa";
        var b = a;
        var obj = new myObj();
        obj.setName(a);
        return obj.getname();
    }

}


