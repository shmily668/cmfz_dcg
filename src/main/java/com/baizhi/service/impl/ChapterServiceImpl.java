package com.baizhi.service.impl;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryChapterPager(Integer page, Integer rows, String albumId) {      //分页查询
        Map<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        List<Chapter> list = chapterDAO.selectChapterPager(start, rows, albumId);
        //总条数
        Integer records = chapterDAO.selectchapterCount(albumId);
        //总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("page", page);
        map.put("rows", list);
        map.put("records", records);
        map.put("total", total);
        return map;
    }

    @Override
    public String addChapter(Chapter chapter) {             //添加章节
        String id = UUID.randomUUID().toString().replace("_", "");
        chapter.setId(id);
        chapterDAO.insert(chapter);
        return id;
    }

    @Override
    public void uploadChapter(MultipartFile src, String chapterId, HttpSession session) {     //音频上传
        String realPath = session.getServletContext().getRealPath("upload/audio");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = src.getOriginalFilename();
        String name = new Date().getTime() + filename;
        try {
            src.transferTo(new File(realPath, name));
            //获取音频文件时长
            AudioFile read = AudioFileIO.read(new File(realPath, name));
            AudioHeader audioHeader = read.getAudioHeader();
            int trackLength = audioHeader.getTrackLength();
            String second = trackLength % 60 + "秒";
            String minute = trackLength / 60 + "分";
            //获取音频文件大小
            long l = src.getSize();             //字节
            String size = l / 1024 / 1024 + "MB";
            Chapter chapter = new Chapter();
            chapter.setId(chapterId);
            chapter.setDuration(minute + second);
            chapter.setSize(size);
            chapter.setSrc(name);
            chapterDAO.updateByPrimaryKeySelective(chapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int changeChapter(Chapter chapter) {             //章节修改
        int i = chapterDAO.updateByPrimaryKeySelective(chapter);
        return i;
    }


    @Override
    public int deleteByPrimaryKey(String[] id) {            //章节删除
        int i = chapterDAO.deleteByPrimaryKeys(id);
        return i;
    }

    @Override
    public void downLoadChapter(String src, HttpSession session, HttpServletResponse response) {        //音频下载
        //获取音频文件路径
        String realPath = session.getServletContext().getRealPath("/upload/audio");
        File file = new File(realPath, src);
        //音频文件名拆分
        String name = src.split("-")[1];
        //设置请求头
        response.setHeader("content-disposition", "attachment;filename=" + name);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            FileUtils.copyFile(file, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关流
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
