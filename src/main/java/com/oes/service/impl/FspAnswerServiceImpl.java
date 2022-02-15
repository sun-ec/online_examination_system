package com.oes.service.impl;

import com.oes.mapper.FspAnswerMapper;
import com.oes.model.FspAnswer;
import com.oes.service.FspAnswerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("fspAnswerService")
public class FspAnswerServiceImpl implements FspAnswerService {

    @Resource
    FspAnswerMapper mapper;

    @Override
    public int save(FspAnswer fspAnswer) {
        return mapper.save(fspAnswer);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public int update(FspAnswer fspAnswer) {
        return mapper.update(fspAnswer);
    }

    @Override
    public FspAnswer findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public List<FspAnswer> findAnswer(FspAnswer fspAnswer) {
        return mapper.findAnswer(fspAnswer);
    }

    @Override
    public String findAnswerStr(FspAnswer fspAnswer) {
        return mapper.findAnswerStr(fspAnswer).getAnswer();
    }
}
