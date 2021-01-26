package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/first")
@RestController
public class hellow {

    @GetMapping(value = "/hello")
    public String helloWord(){
        var a = "aaa";
        var b = a;
        var obj = new myObj();
        obj.setName(a);
        return obj.getname();
    }

}


