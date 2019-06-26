package com.bcu.judge.mapper;

import com.bcu.judge.pojo.PartCustomer;
import com.bcu.judge.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> getRankingByExamId(@Param("examId") String examId);

    Score selectByScoreExamIdAndScoreUserId(@Param("scoreExamId") String scoreExamId, @Param("scoreUserId") String scoreUserId);

    List<Score> selectByScoreUserId(@Param("scoreUserId") String scoreUserId);

    int updateScoreStatusByScoreExamId(@Param("updatedScoreStatus") String updatedScoreStatus, @Param("scoreExamId") String scoreExamId);

    List<PartCustomer> selectScoreByExamIdOrderByGroup(@Param("examId")String examId);

    List<String> selectDistinctScoreUserPartByScoreExamId(@Param("scoreExamId")String scoreExamId);

    List<Score> getRankingByExamIdAndPartId(@Param("partid")String partId,@Param("examid")String examId);


}