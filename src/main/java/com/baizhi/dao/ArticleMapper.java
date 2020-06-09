package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String[] id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    //文章分页查询
    List<Article> selectArticlByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    int selectArticleCount();
}