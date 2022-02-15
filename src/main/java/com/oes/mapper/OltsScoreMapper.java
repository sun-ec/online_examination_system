package com.oes.mapper;

import com.oes.model.OltsScore;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface OltsScoreMapper {
    /**
     * 通过成绩编号查找成绩
     * @param id 成绩编号
     * @return 成绩model
     */
    public OltsScore findById(String id);

    /**
     * 通过学生编号查询成绩表
     * @param userId 学生编号
     * @return 成绩List
     */
    public List<OltsScore> findByUserId(String userId);

    /**
     * 通过考试编号查询成绩表
     * @param examNo 考试编号
     * @return 成绩List
     */
    public List<OltsScore> findByExamNo(String examNo);

    /**
     * 删除一条成绩
     * @param id 成绩编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 通过考试编号和学生编号查询成绩
     * @param oltsScore 成绩model(包含考试编号和学生编号)
     * @return 成绩model
     */
    public OltsScore findByExamNoAndUserId(OltsScore oltsScore);

    /**
     * 添加一条新的成绩
     * @param oltsScore 成绩model
     * @return 被更新的行数
     */
    public int save(OltsScore oltsScore);

    /**
     * 更新主观题成绩
     * @param oltsScore  成绩model
     * @return 被更新的行数
     */
    public int update(OltsScore oltsScore);
}
