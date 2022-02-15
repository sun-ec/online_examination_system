package com.oes.service.impl;

import com.oes.mapper.TechCategoryMapper;
import com.oes.model.TechCategory;
import com.oes.service.TechCategoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("techCategoryService")
public class TechCategoryServiceImpl implements TechCategoryService {

    @Resource
    TechCategoryMapper mapper;

    @Override
    public TechCategory findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<TechCategory> findAll() {
        return mapper.findAll();
    }

    @Override
    public int save(TechCategory techCategory) {
        return mapper.save(techCategory);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public int update(TechCategory techCategory) {
        return mapper.update(techCategory);
    }

    @Override
    public List<TechCategory> findAllLikeName(TechCategory techCategory) {
        return mapper.findAllLikeName(techCategory);
    }


    @Override
    public List<TechCategory> findByCourId(String courId) {
        return mapper.findByCourId(courId);
    }
}
