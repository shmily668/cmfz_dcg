package com.baizhi.service;

import java.util.Map;

public interface ArticleService {
    //文章分页查询
    Map<String, Object> queryArticlePager(Integer page, Integer rows);

    //删除
    int deleteByPrimaryKey(String[] id);
}
