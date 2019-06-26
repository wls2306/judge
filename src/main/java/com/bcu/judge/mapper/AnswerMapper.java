package com.bcu.judge.mapper;

import com.bcu.judge.pojo.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    List<Answer> selectWrongAnswerByAnswerExamIdAndAnswerUserId(@Param("answerExamId") String answerExamId, @Param("answerUserId") String answerUserId);
}