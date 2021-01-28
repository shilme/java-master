package com.example.demo.controller;


import com.example.demo.common.CommonResult;
import com.example.demo.model.AdminModel;
import com.example.demo.model.AdminLoginParamModel;
import com.example.demo.model.PermissionModel;
import com.example.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */

@Controller
@Api(tags = "AdminController", description = "用户管理")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminModel> register(@RequestBody AdminModel adminModel, BindingResult result) {
        AdminModel umsAdmin = adminService.register(adminModel);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody AdminLoginParamModel adminLoginParamModel, BindingResult result) {
        String token = adminService.login(adminLoginParamModel.getUsername(), adminLoginParamModel.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PermissionModel>> getPermissionList(@PathVariable Long adminId) {
        List<PermissionModel> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
