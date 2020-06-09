package com.baizhi.service.impl;

import com.baizhi.dao.ArticleMapper;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryArticlePager(Integer page, Integer rows) {      //文章分页查询
        Integer start = (page - 1) * rows;
        List<Article> list = articleMapper.selectArticlByPage(start, rows);
        //总条数
        int records = articleMapper.selectArticleCount();
        //总页数
        int total = records % rows == 0 ? records / rows : records / rows + 1;
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("rows", list);
        map.put("total", total);
        map.put("records", records);
        return map;
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {            //删除
        int i = articleMapper.deleteByPrimaryKey(id);
        return i;
    }
}
