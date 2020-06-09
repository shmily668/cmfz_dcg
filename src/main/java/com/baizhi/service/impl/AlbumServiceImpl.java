package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> queryAlbumPager(Integer page, Integer rows) {        //专辑分页查询
        Map<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        //调用方法查询
        List<Album> list = albumDAO.selectAlbumPager(start, rows);
        //总条数
        Integer records = albumDAO.selectAlbumCount();
        //总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("page", page);
        map.put("rows", list);
        map.put("records", records);
        map.put("total", total);
        return map;
    }
}
