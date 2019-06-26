package com.bcu.judge.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.mapper.ExamMapper;
import com.bcu.judge.pojo.Exam;

@Service
public class ExamService {

    @Resource
    private ExamMapper examMapper;


    public int deleteByPrimaryKey(Integer id) {
        return examMapper.deleteByPrimaryKey(id);
    }


    public int insert(Exam record) {
        return examMapper.insert(record);
    }


    public int insertSelective(Exam record) {
        return examMapper.insertSelective(record);
    }


    public Exam selectByPrimaryKey(Integer id) {
        return examMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Exam record) {
        return examMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Exam record) {
        return examMapper.updateByPrimaryKey(record);
    }

    public Exam getExamInfo(String id){ return  examMapper.selectByExamId(id); }

    public boolean openExam(String examId){ return examMapper.updateExamStatusByExamId("1",examId)>0?true:false;}

    public boolean closeExam(String examId){ return examMapper.updateExamStatusByExamId("0",examId)>0?true:false; }

}


