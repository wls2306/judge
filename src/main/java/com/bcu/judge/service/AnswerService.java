package com.bcu.judge.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.mapper.AnswerMapper;
import com.bcu.judge.pojo.Answer;

import java.util.List;

@Service
public class AnswerService {

    @Resource
    private AnswerMapper answerMapper;


    public int deleteByPrimaryKey(Integer id) {
        return answerMapper.deleteByPrimaryKey(id);
    }


    public int insert(Answer record) {
        return answerMapper.insert(record);
    }


    public int insertSelective(Answer record) {
        return answerMapper.insertSelective(record);
    }


    public Answer selectByPrimaryKey(Integer id) {
        return answerMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Answer record) {
        return answerMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Answer record) {
        return answerMapper.updateByPrimaryKey(record);
    }

    public List<Answer> getWrongAnswerByExamIdAndUserId(String examId, String userId) {
        return answerMapper.selectWrongAnswerByAnswerExamIdAndAnswerUserId(examId, userId);
    }

}


