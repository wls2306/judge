package com.bcu.judge.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.mapper.UserMapper;
import com.bcu.judge.pojo.User;
@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }


    public User dologin(String userId,String password){ return userMapper.selectByUserIdAndUserPassword(userId,password); }


    public User selectUserByUserId(String userId){ return userMapper.selectByUserId(userId); }


    public String selectUserNameByUserId(String userId){ return userMapper.selectUserNameByUserId(userId); }

}
