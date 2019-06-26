package com.bcu.judge.controller;

import com.bcu.judge.pojo.*;
import com.bcu.judge.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private ExamUserService examUserService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/exam/info/{id}",method = {RequestMethod.GET})
    public String getExamInfo(@PathVariable("id")String examId, Map map)
    {
        Exam e=examService.getExamInfo(examId);
        if (e.getExamStatus().equals("1")) {
            map.put("exam", e);
            return "exam-info";
        }else
        {
            map.put("ptitle","提示");
            map.put("icon","weui-icon-waiting");
            map.put("title","考试尚未开始");
            map.put("content","请您耐心等待考试开始");
            map.put("bhref","../../user/my");
            map.put("bclass","weui-btn_default");
            map.put("bcontent","返    回");
            return "info";
        }

    }

    @RequestMapping(value = "/exam/start/{examId}/{userId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String StartExam(@PathVariable("examId")String examId,@PathVariable("userId")String userId,Map map)
    {
        ExamUser eu=examUserService.selectByExamIdAndUserId(examId,userId);
        if (eu.getHasSubmit().equals("1"))
        {
            map.put("ptitle","提示");
            map.put("icon","weui-icon-warn");
            map.put("title","请勿重复考试");
            map.put("content","您已在本次考试中提交过试卷，请勿重复考试");
            map.put("bhref","../../../user/my");
            map.put("bclass","weui-btn_default");
            map.put("bcontent","返    回");
            return "info";
        }
        else {
            if (examUserService.hasEnteredExam(examId, userId)) {
                Exam e = examService.getExamInfo(examId);
                List<Question> questionList = questionService.getQuestionByPaperId(e.getExamPaperId());
                map.put("exam", e);
                map.put("question", questionList);
                map.put("userId", userId);
                return "paper";
            }
            return "";
        }
    }

    @RequestMapping(value = "/exam/end",method = {RequestMethod.GET,RequestMethod.POST})
    public String EndExam(HttpServletRequest req,String userId,String examId,String paperId,String testTime,String userPart,Map map)throws Exception
    {
        Exam e=examService.getExamInfo(examId);
        if (e.getExamStatus().equals("1")) {
            String index;
            int score = 0;
            int queIndexStart = Integer.parseInt(questionService.getQuestionIdStartByPaperId(paperId));
            int queCount = questionService.getQuestionCountByPaperId(paperId);
            int total = 0;
            for (int i = queIndexStart; i < queIndexStart + queCount; i++) {
                Answer a = new Answer();
                Question q = questionService.getQuestionByQuestionId(i + "");
                String answer = req.getParameter("answer-" + i);
                a.setId(0);
                a.setAnswerExamId(examId);
                a.setAnswerUserId(userId);
                a.setAnswerContent(answer);
                a.setAnswerRightAnswer(q.getQueAnswer());
                a.setAnswerQueScore(q.getQueScore());
                a.setAnswerQueId(i + "");
                total += Integer.parseInt(q.getQueScore());
                if (q.getQueAutoJudge().equals("1")) //启用自动阅卷
                {
                    if (answer.equals(q.getQueAnswer())) {
                        a.setAnswerIsRight("1");
                        a.setAnswerScore(q.getQueScore());
                        a.setAnswerJudgeUsername("System");
                        score += Integer.parseInt(q.getQueScore());
                    } else {
                        a.setAnswerIsRight("0");
                        a.setAnswerScore("0");
                        a.setAnswerJudgeUsername("System");
                    }
                }
                answerService.insert(a);
            }
            Score s = new Score();
            s.setScoreId(examId + "-" + userId);
            s.setScoreExamId(examId);
            s.setScoreUserId(userId);
            s.setScoreResult(score + "");
            s.setScoreTime(testTime);
            s.setScoreStatus("0");
            s.setScoreTotal(total + "");
            s.setScoreUserPart(userPart);
            scoreService.insert(s);

            examUserService.hasSubmitExam(examId, userId);


            map.put("ptitle", "提示");
            map.put("icon", "weui-icon-success");
            map.put("title", "交卷成功");
            map.put("content", "您已完成本次答题，请静候佳绩！");
            map.put("bhref", "../user/my");
            map.put("bclass", "weui-btn_primary");
            map.put("bcontent", "确     定");
            return "info";
        }else {
            map.put("ptitle", "提示");
            map.put("icon", "weui-icon-warn");
            map.put("title", "交卷无效");
            map.put("content", "管理员已经截止答题，您的交卷请求无效！");
            map.put("bhref", "../user/my");
            map.put("bclass", "weui-btn_primary");
            map.put("bcontent", "确     定");
            return "info";

        }



    }

    @RequestMapping(value = "/exam/manage/info/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getManageExamInfo(@PathVariable("examid")String examId,Map map)
    {
        Exam e=examService.getExamInfo(examId);
        map.put("exam",e);
        return "exam-manage";
    }

    @RequestMapping(value = "/exam/manage/open/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody HashMap openExam(@PathVariable("examid")String examid)
    {
        HashMap map=new HashMap();
        map.put("result",examService.openExam(examid));
        return map;
    }

    @RequestMapping(value = "/exam/manage/close/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody HashMap closeExam(@PathVariable("examid")String examid)
    {
        HashMap map=new HashMap();
        map.put("result",examService.closeExam(examid));
        return map;
    }

    /*统计交卷人数*/
    @RequestMapping(value = "/exam/manage/statistics/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody HashMap statisticsExam(@PathVariable("examid")String examId)
    {
        HashMap map=new HashMap();
        String rs="";
        List<String> list=examUserService.getUnsubmitUserNameByExamId(examId);
        System.out.println("size===================="+list.size());
        if (list.size()!=0){
            for (String s:list)
            {
                rs+=s+",";
            }
        }else
        {
            rs="所有人均已提交";
        }
        map.put("result",rs);
        return map;
    }


}
