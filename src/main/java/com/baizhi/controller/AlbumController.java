package com.baizhi.controller;

import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("albumPager")
    public Map<String, Object> selectPager(Integer page, Integer rows) {              //专辑分页
        Map<String, Object> map = albumService.queryAlbumPager(page, rows);
        return map;
    }
}
