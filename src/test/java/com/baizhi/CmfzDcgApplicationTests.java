package com.baizhi;

import com.baizhi.dao.ArticleMapper;
import com.baizhi.dao.BannerDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzDcgApplicationTests {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private BannerDAO bannerDAO;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private ArticleMapper articleMapper;

//    @Test
//    public void contextLoads() {
//        Admin abc = adminService.login("abc");
//        System.out.println(abc);
//    }

    @Test
    public void total() {

    }

}
