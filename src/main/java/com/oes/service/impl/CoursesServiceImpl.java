package com.oes.service.impl;

import com.oes.mapper.CoursesMapper;
import com.oes.model.Courses;
import com.oes.model.TechCategory;
import com.oes.service.CoursesService;
import com.oes.service.TechCategoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("coursesService")
public class CoursesServiceImpl implements CoursesService {

    @Resource
    CoursesMapper mapper;

    @Resource
    TechCategoryService techCategoryService;

    @Override
    public Courses findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<Courses> findAll() {
        return mapper.findAll();
    }

    @Override
    public int delete(String id) {
        for (TechCategory techCategory : techCategoryService.findByCourId(id)) {
            techCategoryService.delete(techCategory.getId());
        }
        return mapper.delete(id);
    }

    @Override
    public int update(Courses courses) {
        return mapper.update(courses);
    }

    @Override
    public int save(Courses courses) {
        return mapper.save(courses);
    }

    @Override
    public List<Courses> findAllLikeName(String courseName) {
        return mapper.findAllLikeName(courseName);
    }
}
