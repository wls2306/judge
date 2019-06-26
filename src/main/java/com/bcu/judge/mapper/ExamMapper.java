package com.bcu.judge.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.bcu.judge.pojo.Exam;
@Mapper
public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    Exam selectByExamId(@Param("examId")String examId);

    int updateExamStatusByExamId(@Param("updatedExamStatus")String updatedExamStatus,@Param("examId")String examId);




}