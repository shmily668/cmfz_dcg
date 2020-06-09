package com.baizhi.service.impl;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryByPager(Integer page, Integer rows) {        //轮播图分页查询
        Map<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        List<Banner> list = bannerDAO.selectPage(start, rows);
        /*
         *  jqgrid 返回  page  rows  records total
         * */
        //records  总条数
        Integer records = bannerDAO.selectTotal();
        //total 总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("page", page);
        map.put("rows", list);
        map.put("records", records);
        map.put("total", total);
        return map;
    }

    @Override
    public Map<String, Object> addBanner(Banner banner) {               //添加轮播图
        Map<String, Object> map = new HashMap<>();
        //使用UUID为添加生成id
        String id = UUID.randomUUID().toString().replace("-", "");
        banner.setId(id);
        int i = bannerDAO.insertSelective(banner);
        map.put("i", i);
        map.put("bannerId", id);
        return map;
    }

    @Override
    public void bannerUpload(MultipartFile img, String bannerId, HttpSession session) { //轮播图上传
        String realPath = session.getServletContext().getRealPath("/upload/img");
        File file = new File(realPath);
        //判断上传存放的文件夹是否存在
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取上传文件名
        String filename = img.getOriginalFilename();
        //结合时间戳生成数据库名称
        String name = new Date().getTime() + "_" + filename;
        try {
            //文件上传
            img.transferTo(new File(realPath, name));
            Banner banner = new Banner();
            banner.setId(bannerId);
            banner.setImg(name);
            //修改
            bannerDAO.updateByPrimaryKeySelective(banner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updateByPrimaryKeySelective(Banner banner) {     //修改
        int i = bannerDAO.updateByPrimaryKeySelective(banner);
        return i;
    }

    @Override
    public int deleteByPrimaryKeys(String[] id) {          //删除
        int i = bannerDAO.deleteByPrimaryKeys(id);
        return i;
    }
}
