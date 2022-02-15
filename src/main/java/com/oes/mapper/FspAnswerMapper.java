package com.oes.mapper;

import com.oes.model.FspAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface FspAnswerMapper {

    /**
     *添加一条(填空题，简答题，编程题)学生答题
     * @param fspAnswer 答题model
     * @return 被更新的行数
     */
    public int save(FspAnswer fspAnswer);

    /**
     * 通过答题编号删除一条(填空题，简答题，编程题)学生答题
     * @param id 答题编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 更新一条(填空题，简答题，编程题)学生答题
     * @param fspAnswer 答题model
     * @return 被更新的行数
     */
    public int update(FspAnswer fspAnswer);

    /**
     * 通过答题编号查询一条(填空题，简答题，编程题)学生答题
     * @param id 答题编号
     * @return 答题model
     */
    public FspAnswer findById(String id);

    /**
     * 通过试卷编号和用户编号查询该用户作答的试卷的简答题，编程题答题内容
     * @param fspAnswer 答题model
     * @return 试卷的简答题，编程题答题内容
     */
    public List<FspAnswer> findAnswer(FspAnswer fspAnswer);

    /**
     * 通过试卷编号和用户编号和题号查询该用户作答的简答题，编程题答题内容
     * @param fspAnswer 答题model
     * @return 用户作答的简答题，编程题答题内容
     */
    public FspAnswer findAnswerStr(FspAnswer fspAnswer);

}
