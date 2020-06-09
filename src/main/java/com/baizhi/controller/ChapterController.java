package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("chapterPager")
    public Map<String, Object> queryChapter(Integer page, Integer rows, String albumId) {
        Map<String, Object> map = chapterService.queryChapterPager(page, rows, albumId);
        return map;
    }

    @RequestMapping("edit")
    public Map<String, Object> edit(Chapter chapter, String albumId, String oper, String[] id) {
        Map<String, Object> map = new HashMap<>();
        if ("add".equals(oper)) {
            String chapterId = chapterService.addChapter(chapter);
            if (chapterId != "" || id != null) {
                map.put("msg", "添加成功");
                map.put("chapterId", chapterId);
            } else {
                map.put("msg", "添加失败");
            }
        } else if ("edit".equals(oper)) {
            //判断用户是否修改音频
            if ("".equals(chapter.getSrc())) {
                chapter.setSrc(null);
                int i = chapterService.changeChapter(chapter);
                if (1 == i) {
                    map.put("msg", "修改成功");
                    map.put("chapterId", null);
                } else {
                    map.put("msg", "修改失败");
                }
            } else {
                int i = chapterService.changeChapter(chapter);
                map.put("msg", "修改成功");
                map.put("chapterId", chapter.getId());
            }
        } else if ("del".equals(oper)) {
            int i = chapterService.deleteByPrimaryKey(id);
            if (i != 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        }
        return map;
    }

    @RequestMapping("uploadChapter")
    public void uploadChapter(MultipartFile src, String chapterId, HttpSession session) {    //音频上传
        chapterService.uploadChapter(src, chapterId, session);
        System.out.println("文件名为：  " + src.getOriginalFilename());
    }

    @RequestMapping("downLoadChapter")
    public void downLoad(String src, HttpSession session, HttpServletResponse response) {
        chapterService.downLoadChapter(src, session, response);
        System.out.println(src);
    }
}
