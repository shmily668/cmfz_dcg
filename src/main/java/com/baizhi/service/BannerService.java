package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface BannerService {
    //分页查询
    Map<String, Object> queryByPager(Integer page, Integer rows);

    //添加
    Map<String, Object> addBanner(Banner banner);

    //轮播图上传
    void bannerUpload(MultipartFile img, String bannerId, HttpSession session);

    //修改
    int updateByPrimaryKeySelective(Banner banner);

    //删除
    int deleteByPrimaryKeys(String[] id);
}
