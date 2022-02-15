package com.oes.mapper;

import com.oes.model.FspQuestions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface FspQuestionsMapper {
    /**
     * 添加一条试题(填空题，简答题，编程题)
     * @param fspQuestions 试题model
     * @return 被更新的行数
     */
    public int save(FspQuestions fspQuestions);

    /**
     * 更新一条试题(填空题，简答题，编程题)
     * @param fspQuestions 试题model
     * @return 被更新的行数
     */
    public int update(FspQuestions fspQuestions);

    /**
     * 删除试题(填空题，简答题，编程题)
     * @param id 试题编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 通过试题编号查询试题(填空题，简答题，编程题)
     * @param id 试题编号
     * @return 试题model
     */
    public FspQuestions findById(String id);

    /**
     * 分页查询试题(简答题，编程题)
     * @param fspQuestions
     * @param pageNum 当前页号
     * @param pageSize 每页记录数
     * @return 符合搜索条件的试题(简答题，编程题)list
     */
    public List<FspQuestions> selectByPage(@Param("fspQuestions") FspQuestions fspQuestions,
                                            @Param("pageNum") int pageNum,
                                            @Param("pageSize") int pageSize);
}
