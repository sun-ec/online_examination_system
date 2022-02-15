package com.oes.service;

import com.oes.model.SmdOptions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
public interface SmdOptionsService {

    /**
     * 添加一条单选、多选题选项
     * @param smdOptions 选项model
     * @return 被更新的行数
     */
    public int save(SmdOptions smdOptions);

    /**
     * 删除选项
     * @param id 选项编号
     * @return 被更新的行数
     */
    public int delete(String id);

    /**
     * 更新选项
     * @Param smdOptions 选项model
     * @return 被更新的行数
     */
    public int update(SmdOptions smdOptions);

    /**
     * 通过选项编号查找选项
     * @param id 选项编号
     * @return 选项model
     */
    public SmdOptions findById(String id);

    /**
     * 通过试题表(单选题，多选题)编号查找选项
     * @param id 试题表(单选题，多选题)编号
     * @return 选项model
     */
    public SmdOptions findBySmdId(String id);

    /**
     * 分页查询单选题/多选题
     * @param smdOptions 单选、多选题选项表
     * @param pageNum 当前页
     * @param pageSize 每页记录数
     * @return 符合查询条件的单选题/多选题
     */
    public List<SmdOptions> selectByPage(@Param("smdOptions") SmdOptions smdOptions,
                                         @Param("pageNum") int pageNum,
                                         @Param("pageSize") int pageSize);
}
