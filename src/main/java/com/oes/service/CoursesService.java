package com.oes.service;

import com.oes.model.Courses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
public interface CoursesService {
    /**
     * 通过课程编号查找课程
     * @param id 课程编号
     * @return 课程model
     */
    public Courses findById(String id);

    /**
     * 查询所有课程
     * @return 所有课程List
     */
    public List<Courses> findAll();

    /**
     * 删除一个课程
     * @param id 课程编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 更新一个课程
     * @param courses 课程model
     * @return 被更新的行数
     */
    public int update(Courses courses);

    /**
     * 添加一个新的课程
     * @param courses 课程model
     * @return 被更新的行数
     */
    public int save(Courses courses);

    /**
     * 根据课程名模糊查询课程
     * @param courseName 课程名
     * @return 符合查询条件的课程List
     */
    public List<Courses> findAllLikeName(@Param("courseName") String courseName);
}
