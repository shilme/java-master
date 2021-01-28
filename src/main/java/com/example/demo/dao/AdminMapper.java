package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.AdminModel;
import com.example.demo.model.UmsAdminExample;

import java.util.List;

public interface AdminMapper extends BaseMapper<AdminModel> {


    List<AdminModel> selectByExample(AdminModel example);


    List<AdminModel> getAdminByUsername(String username);
}
