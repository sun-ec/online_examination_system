package com.oes.mapper;

import com.oes.model.Examination;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface ExaminationMapper {
    /**
     * 通过考卷编号查找考卷
     * @param id 考卷编号
     * @return 考卷model
     */
    public Examination findById(String id);

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
