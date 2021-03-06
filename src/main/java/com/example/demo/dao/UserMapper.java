package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// extends BaseMapper<user>
public interface UserMapper extends BaseMapper<UserModel> {

    List<UserModel> getAll();

    UserModel login(String userName, String passWrod);

    UserModel getAdminByUsername(String username);
    /*
  查所有
  return List<Person>

    List<user> getAll();

  /*
    根据ID查询
    {id} 要查询人员的 id
     *//*
    user getPersonByID(int id);

    *//*
    删除
    {id} 要删除人员的 id
     *//*
    void delete(int id);

    *//*
    更新
    {p} 要更新的Person实例
     *//*
    void update(user p);

    *//*
    增加
    {p} 要新增的Person实例
     *//*
    void newp(user p);*/
}
