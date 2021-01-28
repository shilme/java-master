package com.example.demo.dao;

import com.example.demo.model.PermissionModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleRelationMapper {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<PermissionModel> getPermissionList(@Param("adminId") Long adminId);
}
