package com.oes.service.impl;

import com.oes.mapper.SmdOptionsMapper;
import com.oes.model.SmdOptions;
import com.oes.service.SmdOptionsService;
import org.omg.CORBA.MARSHAL;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("smdOptionsService")
public class  SmdOptionsServiceImpl implements SmdOptionsService {

    @Resource
    SmdOptionsMapper mapper;

    @Override
    public int save(SmdOptions smdOptions) {
        return mapper.save(smdOptions);
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public int update(SmdOptions smdOptions) {
        return mapper.update(smdOptions);
    }


    @Override
    public SmdOptions findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public SmdOptions findBySmdId(String id) {
        return mapper.findBySmdId(id);
    }

    @Override
    public List<SmdOptions> selectByPage(SmdOptions smdOptions, int pageNum, int pageSize) {
        return mapper.selectByPage(smdOptions, pageNum, pageSize);
    }
}
