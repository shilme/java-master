package com.example.demo.controller;

import com.example.demo.model.UserModel;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Api(tags = "UserContorller", description = "用户测试")
@RequestMapping("/user")

//@RequestMapping(value = "/user")
//@RestController
public class userContorller {
    @Autowired
    com.example.demo.service.userService userService;

    @GetMapping(value = "/get")
    public Object get(){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        List<UserModel> list = userService.getAll();
        return list;
    }
    @GetMapping(value = "/login")
    public UserModel Login(String userName, String PasswWord)
    {
        UserModel user =userService.Login(userName,PasswWord);
        return user;
    }
}


