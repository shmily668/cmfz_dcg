package com.baizhi.service;

import java.util.Map;

public interface AlbumService {
    //专辑分页查询
    Map<String, Object> queryAlbumPager(Integer page, Integer rows);
}
