package com.oes.service.impl;

import com.oes.mapper.ExaminationMapper;
import com.oes.mapper.FspAnswerMapper;
import com.oes.mapper.OltsScoreMapper;
import com.oes.model.*;
import com.oes.service.ExaminationSerivce;
import com.oes.service.OltsScoreService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("oltsScoreService")
public class OltsScoreServiceImpl implements OltsScoreService {

    @Resource
    OltsScoreMapper mapper;

    @Override
    public OltsScore findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public int update(OltsScore oltsScore) {
        return mapper.update(oltsScore);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public List<OltsScore> findByUserId(String userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public List<OltsScore> findByExamNo(String examNo) {
        return mapper.findByExamNo(examNo);
    }

    @Override
    public OltsScore findByExamNoAndUserId(OltsScore oltsScore) {
        return mapper.findByExamNoAndUserId(oltsScore);
    }

    @Override
    public int save(OltsScore oltsScore) {
        return mapper.save(oltsScore);
    }

}
