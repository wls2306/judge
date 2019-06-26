package com.bcu.judge.mapper;
import java.util.Date;
import com.bcu.judge.pojo.Exam;
import org.apache.ibatis.annotations.Param;

import com.bcu.judge.pojo.ExamUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamUser record);

    int insertSelective(ExamUser record);

    ExamUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamUser record);

    int updateByPrimaryKey(ExamUser record);

    List<Exam> selectByUserId(@Param("userId")String userId);

    int updateHasEnterAndEnterTimeByExamIdAndUserId(@Param("examId")String examId,@Param("userId")String userId);

    int updateHasSubmitAndSubmitTimeByExamIdAndUserId(@Param("examId")String examId,@Param("userId")String userId);

    ExamUser selectByExamIdAndUserId(@Param("examId")String examId,@Param("userId")String userId);

    List<String> getUnsubmitUserNameByExamId(@Param("examid")String examid);





}