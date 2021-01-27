package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.UmsAdminExample;

import java.util.List;

public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {


    List<UmsAdmin> selectByExample(UmsAdminExample example);

}
