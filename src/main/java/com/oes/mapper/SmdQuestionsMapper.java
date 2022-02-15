package com.oes.mapper;

import com.oes.model.SmdQuestions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface SmdQuestionsMapper {
    /**
     * 添加一个试题(单选题，多选,判断题)
     * @param smdQuestions 试题model
     * @return 被更新的行数
     */
    public int save(SmdQuestions smdQuestions);

    /**
     * 通过试题编号查询试题
     * @param id 试题编号
     * @return 试题model
     */
    public SmdQuestions findById(String id);

    /**
     * 更新试题
     * @param smdQuestions 试题model
     * @return 被更新的行数
     */
    public int update(SmdQuestions smdQuestions);

    /**
     * 删除试题
     * @param id 试题编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 分页查询
     * @param smdQuestions  试题表(单选题，多选,判断题)model
     * @param pageNum 当前页号
     * @param pageSize 每页记录数
     * @return 符合搜索条件的试题表(单选题，多选,判断题)list
     */
    public List<SmdQuestions> selectByPage(@Param("smdQuestions") SmdQuestions smdQuestions,
                                            @Param("pageNum") int pageNum,
                                            @Param("pageSize") int pageSize);
}
