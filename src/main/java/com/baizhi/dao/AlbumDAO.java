package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO {
    int deleteByPrimaryKey(String id);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    //专辑分页查询
    List<Album> selectAlbumPager(@Param("start") Integer start, @Param("rows") Integer rows);

    //数据总条数
    int selectAlbumCount();
}