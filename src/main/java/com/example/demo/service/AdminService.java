package com.example.demo.service;

import com.example.demo.model.AdminModel;
import com.example.demo.model.PermissionModel;

import java.util.List;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
public interface AdminService {
    /**
     * 根据用户名获取后台管理员
     */
    AdminModel getAdminByUsername(String username);

    /**
     * 注册功能
     */
    AdminModel register(AdminModel adminModel);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<PermissionModel> getPermissionList(Long adminId);
}