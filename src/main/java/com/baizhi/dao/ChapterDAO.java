package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDAO {
    int deleteByPrimaryKeys(String[] id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    //分页查询
    List<Chapter> selectChapterPager(@Param("start") Integer start, @Param("rows") Integer rows, @Param("albumId") String albumId);

    //查询总条数
    Integer selectchapterCount(String albumId);
}