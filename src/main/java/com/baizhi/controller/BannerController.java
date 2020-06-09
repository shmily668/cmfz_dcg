package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("querybannerByPager")
    public Map<String, Object> findBanner(Integer page, Integer rows) {            //分页查询
        Map<String, Object> map = bannerService.queryByPager(page, rows);
        return map;
    }

    @RequestMapping("editBanner")
    public Map<String, Object> addBanner(Banner banner, String oper, String[] id) {             //增删改
        Map<String, Object> map = new HashMap<>();
        if ("add".equals(oper)) {
            Map<String, Object> map1 = bannerService.addBanner(banner);
            if (map1.get("i").equals(1)) {
                map.put("msg", "添加成功");
                //获取上传banner的id
                map.put("bannerId", map1.get("bannerId"));
            } else {
                map.put("msg", "添加失败");
            }
        } else if ("edit".equals(oper)) {
            //判断是否修改图片
            if (banner.getImg() == "") {
                banner.setImg(null);
                bannerService.updateByPrimaryKeySelective(banner);
                map.put("msg", "修改成功");
                map.put("bannerId", null);
            } else {
                //修改图片
                bannerService.updateByPrimaryKeySelective(banner);
                map.put("msg", "修改成功");
                map.put("bannerId", banner.getId());
            }
        } else if ("del".equals(oper)) {
            int i = bannerService.deleteByPrimaryKeys(id);
            if (0 != i) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        }
        return map;
    }

    @RequestMapping("bannerUpload")
    public void bannerUpload(MultipartFile img, String bannerId, HttpSession session) {
        bannerService.bannerUpload(img, bannerId, session);
    }
}
