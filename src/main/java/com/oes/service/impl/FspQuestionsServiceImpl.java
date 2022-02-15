package com.oes.service.impl;

import com.oes.mapper.FspQuestionsMapper;
import com.oes.model.FspQuestions;
import com.oes.service.FspQuestionsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("fspQuestionsService")
public class FspQuestionsServiceImpl implements FspQuestionsService {

    @Resource
    FspQuestionsMapper mapper;

    @Override
    public int save(FspQuestions fspQuestions) {
        return mapper.save(fspQuestions);
    }

    @Override
    public int update(FspQuestions fspQuestions) {
        return mapper.update(fspQuestions);
    }


    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public FspQuestions findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<FspQuestions> selectByPage(FspQuestions fspQuestions, int pageNum, int pageSize) {
        return mapper.selectByPage(fspQuestions, pageNum, pageSize);
    }
}
