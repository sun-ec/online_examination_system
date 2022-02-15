package com.oes.service.impl;

import com.oes.controller.OltsUsersController;
import com.oes.mapper.OltsUsersMapper;
import com.oes.model.OltsUsers;
import com.oes.model.POIUtils;
import com.oes.service.OltsUsersService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("oltsUsersService")
public class OltsUsersServiceImpl implements OltsUsersService {

    @Resource
    OltsUsersMapper mapper;

    static Logger logger= Logger.getLogger(OltsUsersServiceImpl.class);

    @Override
    public List<OltsUsers> findBySch(String sch) {
        return mapper.findBySch(sch);
    }

    @Override
    public void bulkInsert(InputStream is, int sheetNo, String sch) {
        List<List<String>> readExcel = POIUtils.readExcel(is, sheetNo);
        OltsUsers user=new OltsUsers();
        if(sch!=null){
            user.setSchAddr(sch);
        }
        user.setPassWord("123456");
        int rows=readExcel.size();
        for (int i=1;i<rows;i++) {
            List<String> list=readExcel.get(i);
            if(list.get(1)==null || "".equals(list.get(1))){
                break;
            }
            //对应工作表的第1列：姓名
            user.setUserName(list.get(1));
            //对应工作表的第2列：身份证
            user.setIdCardNo(list.get(2));
            //对应工作表的第3列：手机号
            user.setMobile(list.get(5));
            //对应工作表的第4列：QQ号
            user.setQq(list.get(6));
            try {
                mapper.save(user);
            } catch (Exception e) {
                e.printStackTrace();
                logger.warn("插入错误，已存在该身份证号的用户");
            }
        }
    }

    @Override
    public OltsUsers findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public int deleteById(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public OltsUsers login(OltsUsers oltsUsers) {
        return mapper.login(oltsUsers);
    }

    @Override
    public int save(OltsUsers oltsUsers) {
        return mapper.save(oltsUsers);
    }

    @Override
    public int update(OltsUsers oltsUsers) {
        return mapper.update(oltsUsers);
    }
}
