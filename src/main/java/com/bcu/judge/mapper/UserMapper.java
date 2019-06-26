package com.bcu.judge.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.bcu.judge.pojo.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserIdAndUserPassword(@Param("userId")String userId,@Param("userPassword")String userPassword);

    User selectByUserId(@Param("userId")String userId);

    String selectUserNameByUserId(@Param("userId")String userId);



}