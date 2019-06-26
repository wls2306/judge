package com.bcu.judge.controller;

import com.bcu.judge.pojo.Answer;
import com.bcu.judge.pojo.AnswerCustomer;
import com.bcu.judge.pojo.Exam;
import com.bcu.judge.pojo.Question;
import com.bcu.judge.service.AnswerService;
import com.bcu.judge.service.ExamService;
import com.bcu.judge.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/answer/mistake/{examId}/{userId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getMistakeByExamIdAndUserId(@PathVariable("examId")String examId, @PathVariable("userId")String userId, Map map)
    {
        List<Answer> wrongAnswerList=answerService.getWrongAnswerByExamIdAndUserId(examId,userId);
        List<AnswerCustomer> list=new ArrayList<>();
        Exam e= examService.getExamInfo(examId);
        for (Answer a:wrongAnswerList)
        {
            AnswerCustomer ac=new AnswerCustomer();
            Question q= questionService.getQuestionByQuestionId(a.getAnswerQueId());
            ac.setQueId(a.getAnswerQueId());
            ac.setQueContent(q.getQueContent());
            ac.setWrongAnswer(a.getAnswerContent());
            ac.setRightAnswer(q.getQueAnswer());
            ac.setScore(q.getQueScore());
            list.add(ac);
        }
        map.put("list",list);
        map.put("exam",e);
        return "mistake";
    }
}
