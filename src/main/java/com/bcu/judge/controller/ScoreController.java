package com.bcu.judge.controller;

import com.bcu.judge.pojo.*;
import com.bcu.judge.service.ExamService;
import com.bcu.judge.service.PartService;
import com.bcu.judge.service.ScoreService;
import com.bcu.judge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ExamService examService;
    @Autowired
    private UserService userService;
    @Autowired
    private PartService partService;

    /**
     *
     * **********************************************************************
     * **********************************************************************
     * *************************** ！注意！**********************************
     *
     * Mysql中数字排序问题 如果排序 Varchar的数据 需要
     * order by  字段名 +0
     * 否则会排序出错（按照字符）
     *
     * **********************************************************************
     * **********************************************************************
     * **********************************************************************

     * @param examId
     * @param map
     * @return
     */
    @RequestMapping(value = "/score/rank/{examId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getRankByExamId(@PathVariable("examId")String examId, Map map)
    {
        int i=1;
        List<Score> scoreList=scoreService.getRankByExamId(examId);
        Exam e=examService.getExamInfo(examId);
        map.put("exam",e);
        List<RankCustomer> rankList=new ArrayList<>();
        for (Score s:scoreList)
        {
            User u=userService.selectUserByUserId(s.getScoreUserId());
            RankCustomer rankCustomer=new RankCustomer();
            rankCustomer.setName(u.getUserName());
            rankCustomer.setScore(s.getScoreResult());
            rankCustomer.setTime(s.getScoreTime());
            rankList.add(rankCustomer);

            if (i<=3&&s!=null)
            {
                switch (i){
                    case 1:
                        map.put("first",rankCustomer);
                        break;

                    case 2:
                        map.put("second",rankCustomer);
                        break;

                    case 3:
                        map.put("third",rankCustomer);
                        break;
                }
            }
            i+=1;

        }

        map.put("list",rankList);
        return "rank";
    }

    @RequestMapping(value = "/score/select/{examId}/{userId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getScoreByExamIdAndUserId(@PathVariable("examId")String examId,@PathVariable("userId")String userId, Map map)
    {
        Score s=scoreService.getScoreByExamIdAndUserId(examId,userId);
        if (s.getScoreStatus().equals("1")) {
            Exam e = examService.getExamInfo(s.getScoreExamId());
            User u = userService.selectUserByUserId(s.getScoreUserId());
            map.put("exam", e);
            map.put("score", s);
            map.put("user", u);
            return "score";
        }else
        {
            map.put("ptitle","提示");
            map.put("icon","weui-icon-waiting");
            map.put("title","分数尚未公布");
            map.put("content","请耐心等待分数公布");
            map.put("bhref","../../../user/my");
            map.put("bclass","weui-btn_default");
            map.put("bcontent","返    回");
            return "info";
        }
    }

    @RequestMapping(value = "/score/select/{userId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getScoreByUserId(@PathVariable("userId")String userId,Map map)
    {
        List<Score> scoreList=scoreService.selectByScoreUserId(userId);
        List<ScoreCustomer> scoreCustomerlist=new ArrayList<>();
        for (Score s:scoreList)
        {
            ScoreCustomer sc=new ScoreCustomer();
            Exam e=examService.getExamInfo(s.getScoreExamId());
            sc.setExamId(e.getExamId());
            sc.setExamName(e.getExamName());
            sc.setPaperId(e.getExamPaperId());
            sc.setScore(s.getScoreResult());
            sc.setStatus(s.getScoreStatus());
            sc.setTime(s.getScoreTime());
            sc.setTotal(s.getScoreTotal());
            scoreCustomerlist.add(sc);
        }
        map.put("list",scoreCustomerlist);
        return  "score-list";
    }

    @RequestMapping(value = "/score/publish/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody HashMap publishScoreByExamId(@PathVariable("examid")String examId)
    {
        HashMap map=new HashMap();
        map.put("result",scoreService.publishResultByExamId(examId));
        return map;
    }

    @RequestMapping(value = "/score/rank-group/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getRankGroupByExamId(@PathVariable("examid")String examId,Map map)
    {
        Exam e=examService.getExamInfo(examId);
        List<PartCustomer> list=scoreService.selectScoreByExamIdOrderByGroup(examId);
        map.put("list",list);
        map.put("exam",e);
        return "group-rank";
    }

    @RequestMapping(value = "/score/rank-ingroup/{examid}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getRankInGroupByExamId(@PathVariable("examid")String examid,Map map)
    {
        List<String> partList=scoreService.selectDistinctScoreUserPartByScoreExamId(examid);
        List<RankCustomer> rkList=new ArrayList<>();
        Exam e=examService.getExamInfo(examid);
        for (String s:partList)
        {
            List<Score> scoreList=scoreService.getRankingByExamIdAndPartId(s,examid);

            for (Score score:scoreList)
            {

                RankCustomer rc=new RankCustomer();
                rc.setTime(score.getScoreTime());
                rc.setScore(score.getScoreResult());
                rc.setName( userService.selectUserNameByUserId(score.getScoreUserId()));
                rc.setPart(partService.selectPartNameByPartId(score.getScoreUserPart()));
                rkList.add(rc);
            }

        }
        map.put("list",rkList);
        map.put("exam",e);
        return "ingroup-rank";
    }


}
