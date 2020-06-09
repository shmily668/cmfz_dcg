package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ChapterService {
    //章节分页查询
    Map<String, Object> queryChapterPager(Integer page, Integer rows, String albumId);

    //添加
    String addChapter(Chapter chapter);

    //音频上传
    void uploadChapter(MultipartFile src, String chapterId, HttpSession session);

    //章节修改
    int changeChapter(Chapter chapter);

    //章节删除
    int deleteByPrimaryKey(String[] id);

    //章节下载
    void downLoadChapter(String src, HttpSession session, HttpServletResponse response);
}
