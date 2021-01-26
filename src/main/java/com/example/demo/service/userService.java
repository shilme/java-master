package com.example.demo.service;



import com.example.demo.dao.UserDao;
import com.example.demo.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    UserDao userDao;
    /*
        Service层介于controller和dao之间作为服务层进行一些逻辑处理，
        这里逻辑太简单所以知识单纯调用dao所以不做注释
     */
    public List<user> getAll(){
        return userDao.selectList(null);
    }

//
//    public user getPersonByID(int id){
//        return userDao.getPersonByID(id);
//    }
//
//    public void  delete(int id){
//        userDao.delete(id);
//    }
//
//    public void update(user p){
//        userDao.update(p);
//    }
//
//    public void newp(user p) {
//        userDao.newp(p);
//    }
}
