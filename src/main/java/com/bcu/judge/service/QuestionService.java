package com.bcu.judge.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.mapper.QuestionMapper;
import com.bcu.judge.pojo.Question;

import java.util.List;

@Service
public class QuestionService{

    @Resource
    private QuestionMapper questionMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return questionMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Question record) {
        return questionMapper.insert(record);
    }

    
    public int insertSelective(Question record) {
        return questionMapper.insertSelective(record);
    }

    
    public Question selectByPrimaryKey(Integer id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Question record) {return questionMapper.updateByPrimaryKeySelective(record);}

    
    public int updateByPrimaryKey(Question record) {
        return questionMapper.updateByPrimaryKey(record);
    }


    public List<Question> getQuestionByPaperId(String paperId){ return questionMapper.selectByQuePaperId(paperId); }

    public int getQuestionCountByPaperId(String paperId){ return questionMapper.selectQuestionCountByPaperId(paperId); }

    public String getQuestionIdStartByPaperId(String paperId){ return questionMapper.selectQuesionIndexByPaperId(paperId); }

    public Question getQuestionByQuestionId(String queId){return questionMapper.selectByQueId(queId);}
}
