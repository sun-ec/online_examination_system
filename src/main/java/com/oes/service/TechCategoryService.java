package com.oes.service;

import com.oes.model.TechCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
public interface TechCategoryService {
    /**
     * 通过知识点分类的编号查询对应知识点
     * @param id 知识点编号
     * @return 知识点
     */
    public TechCategory findById(String id);

    /**
     * 查询所有的知识点分类
     * @return 所有的知识点分类List
     */
    public List<TechCategory> findAll();

    /**
     * 添加一个新的知识点
     * @param techCategory 知识点model
     * @return 被更新的行数
     */
    public int save(TechCategory techCategory);

    /**
     * 删除一个知识点
     * @param id 知识点编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 更新一个知识点
     * @param techCategory 知识点model
     * @return 被更新的行数
     */
    public int update(TechCategory techCategory);

    /**
     * 根据知识点名模糊查询
     * @param techCategory 知识点model
     * @return 符合查询条件的知识点List
     */
    public List<TechCategory> findAllLikeName(TechCategory techCategory);

    /**
     * 通过课程号查询所属知识点
     * @param courId 课程编号
     * @return 所属知识点List
     */
    public List<TechCategory> findByCourId(String courId);
}
