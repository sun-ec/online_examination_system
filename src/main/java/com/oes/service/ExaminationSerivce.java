package com.oes.service;

import com.oes.model.Examination;
import com.oes.model.FspQuestions;

import java.util.List;
import java.util.Map;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
public interface ExaminationSerivce {

    /**
     * 为指定试卷的指定题型添加题目
     * @param examNo 试卷编号
     * @param topicId 试题编号字符串(以,间隔)
     * @param type 试题类型
     * @return 本更新的行数
     */
    public int addTopic(String examNo,String topicId,String type);

    /**
     * 为指定试卷的指定题型移除题目
     * @param examNo 试卷编号
     * @param topicId 试题编号
     * @param type 试题类型
     * @return 本更新的行数
     */
    public int removeTopic(String examNo,String topicId,String type);

    /**
     * 通过考卷编号查找考卷
     * @param id 考卷编号
     * @return 考卷model
     */
    public Examination findById(String id);

    /**
     * 通过试卷编号查询该试卷的所有考题内容
     * @param id 试卷编号
     * @return 所有考题内容
     */
    public Map<String, List<Object>> queryPaper(String id);

    /**
     * 通过试卷编号查询该试卷的所有主观题的内容
     * @param id 试卷编号
     * @return 该试卷的所有主观题的内容
     */
    public Map<String,List<FspQuestions>> querySubjectiveProblem(String id);

    /**
     * update
     * @param examination 试卷model
     * @return 被更新的行数
     */
    public int update(Examination examination);

    /**
     * 添加考试
     * @param examination 试卷model
     * @return 被更新的行数
     */
    public int save(Examination examination);

    /**
     * 查询所有试卷的编号
     * @return 所有试卷的编号List
     */
    public List<Examination> findAllExamNo();
}
