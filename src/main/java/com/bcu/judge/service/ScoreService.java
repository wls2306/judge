package com.bcu.judge.service;

import com.bcu.judge.pojo.PartCustomer;
import com.bcu.judge.pojo.RankCustomer;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.pojo.Score;
import com.bcu.judge.mapper.ScoreMapper;

import java.util.List;

@Service
public class ScoreService {

    @Resource
    private ScoreMapper scoreMapper;


    public int deleteByPrimaryKey(Integer id) {
        return scoreMapper.deleteByPrimaryKey(id);
    }


    public int insert(Score record) {
        return scoreMapper.insert(record);
    }


    public int insertSelective(Score record) {
        return scoreMapper.insertSelective(record);
    }


    public Score selectByPrimaryKey(Integer id) {
        return scoreMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Score record) {
        return scoreMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Score record) {
        return scoreMapper.updateByPrimaryKey(record);
    }


    public List<Score> getRankByExamId(String examId) {
        return scoreMapper.getRankingByExamId(examId);
    }


    public Score getScoreByExamIdAndUserId(String examId, String userId) { return scoreMapper.selectByScoreExamIdAndScoreUserId(examId, userId); }


    public List<Score> selectByScoreUserId(String userId) {
        return scoreMapper.selectByScoreUserId(userId);
    }


    public boolean publishResultByExamId(String examid) { return scoreMapper.updateScoreStatusByScoreExamId("1", examid) > 0 ? true : false;    }


    public List<PartCustomer> selectScoreByExamIdOrderByGroup(String examid){ return scoreMapper.selectScoreByExamIdOrderByGroup(examid); }


    public List<String> selectDistinctScoreUserPartByScoreExamId(String examid){ return scoreMapper.selectDistinctScoreUserPartByScoreExamId(examid); }


    public List<Score> getRankingByExamIdAndPartId(String partId,String examId){ return scoreMapper.getRankingByExamIdAndPartId(partId,examId); }
}


