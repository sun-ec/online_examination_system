package com.oes.service.impl;

import com.oes.mapper.SmdQuestionsMapper;
import com.oes.model.SmdQuestions;
import com.oes.service.SmdQuestionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("smdQuestionsService")
public class SmdQuestionsServiceImpl implements SmdQuestionsService {

    @Resource
    SmdQuestionsMapper mapper;

    @Override
    public int save(SmdQuestions smdQuestions) {
        return mapper.save(smdQuestions);
    }

    @Override
    public SmdQuestions findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public int update(SmdQuestions smdQuestions) {
        return mapper.update(smdQuestions);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public List<SmdQuestions> selectByPage(SmdQuestions smdQuestions, int pageNum, int pageSize) {
        return mapper.selectByPage(smdQuestions,pageNum,pageSize);
    }
}
