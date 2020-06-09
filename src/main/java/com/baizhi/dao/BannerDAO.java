package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO {
    //删除
    int deleteByPrimaryKeys(String[] id);

    //添加
    int insert(Banner record);

    //条件添加
    int insertSelective(Banner record);

    //id查询
    Banner selectByPrimaryKey(String id);

    //条件修改
    int updateByPrimaryKeySelective(Banner record);

    //主键修改
    int updateByPrimaryKey(Banner record);

    //分页查询
    List<Banner> selectPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    Integer selectTotal();

}