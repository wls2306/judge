package com.bcu.judge.service;

import com.bcu.judge.pojo.Exam;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.pojo.ExamUser;
import com.bcu.judge.mapper.ExamUserMapper;

import java.util.List;

@Service
public class ExamUserService{

    @Resource
    private ExamUserMapper examUserMapper;
    
    public int deleteByPrimaryKey(Integer id) {
        return examUserMapper.deleteByPrimaryKey(id);
    }
    
    public int insert(ExamUser record) {
        return examUserMapper.insert(record);
    }

    public int insertSelective(ExamUser record) {
        return examUserMapper.insertSelective(record);
    }
    
    public ExamUser selectByPrimaryKey(Integer id) {
        return examUserMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(ExamUser record) { return examUserMapper.updateByPrimaryKeySelective(record); }

    public int updateByPrimaryKey(ExamUser record) {
        return examUserMapper.updateByPrimaryKey(record);
    }

    public List<Exam> getExamByUserId(String userId){ return examUserMapper.selectByUserId(userId); }

    public boolean hasEnteredExam(String examId,String userId){return examUserMapper.updateHasEnterAndEnterTimeByExamIdAndUserId(examId,userId)>0?true:false;}

    public boolean hasSubmitExam(String examId,String userId) { return  examUserMapper.updateHasSubmitAndSubmitTimeByExamIdAndUserId(examId,userId)>0?true:false; }

    public ExamUser selectByExamIdAndUserId(String examId,String userId){ return examUserMapper.selectByExamIdAndUserId(examId,userId);}

    public List<String> getUnsubmitUserNameByExamId(String examid){ return examUserMapper.getUnsubmitUserNameByExamId(examid); }

}
