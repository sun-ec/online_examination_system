package com.oes.mapper;

import com.oes.model.OltsUsers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Repository
public interface OltsUsersMapper {

    /**
     * 通过授课学校查询用户
     * @param sch 授课学校
     * @return 用户List
     */
    public List<OltsUsers> findBySch(@Param("sch") String sch);

    /**
     * 通过用户编号查找用户
     * @param id 用户编号
     * @return 用户model
     */
    public OltsUsers findById(String id);

    /**
     * 通过用户编号删除用户
     * @param id 用户编号
     * @return 被更新的行数
     */
    public int deleteById(String id);

    /**
     * 用户登录
     * @param oltsUsers 包含用户名和密码的用户model
     * @return 含完整信息的用户model
     */
    public OltsUsers login(OltsUsers oltsUsers);

    /**
     * 添加一名新用户
     * @param oltsUsers 用户model
     * @return 被更新的行数
     */
    public int save(OltsUsers oltsUsers);

    /**
     * 更新一名用户的信息
     * @param oltsUsers 用户model
     * @return 被更新的行数
     */
    public int update(OltsUsers oltsUsers);
}
