package com.bcu.judge.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.bcu.judge.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectByQuePaperId(@Param("quePaperId")String quePaperId);

    int selectQuestionCountByPaperId(@Param("quePaperId")String quePaperId);

    String selectQuesionIndexByPaperId(@Param("quePaperId")String quePaperId);

    Question selectByQueId(@Param("queId")String queId);


}