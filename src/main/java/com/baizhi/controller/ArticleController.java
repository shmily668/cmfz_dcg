package com.baizhi.controller;

import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("artilceByPager")
    public Map<String, Object> queryArticlePager(Integer page, Integer rows) {
        Map<String, Object> map = articleService.queryArticlePager(page, rows);
        return map;
    }

    @RequestMapping("edit")
    public Map<String, Object> edit(String[] id, String oper) {
        Map<String, Object> map = new HashMap<>();
        if ("del".equals(oper)) {
            int i = articleService.deleteByPrimaryKey(id);
            if (0 != i) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        }
        return map;
    }
}
