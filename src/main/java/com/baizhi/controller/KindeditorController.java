package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("kindeditor")
public class KindeditorController {

    @RequestMapping("uploadImg")
    public Map<String, Object> uploadImg(MultipartFile img, HttpSession session, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String realPath = session.getServletContext().getRealPath("upload/img");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = img.getOriginalFilename();
        //防止重名 定义时间戳
        String name = new Date().getTime() + "_" + filename;
        try {
            img.transferTo(new File(realPath, name));
            map.put("error", 0);
            //获取http
            String scheme = request.getScheme();
            //获取localhost          DESKTOP-J4D5LAO/192.168.11.1             电脑昵称/IP地址
            InetAddress localHost = InetAddress.getLocalHost();
            String localhost = localHost.toString().split("/")[1];
            //获取端口号
            int serverPort = request.getServerPort();
            //获取项目名
            String contextPath = request.getContextPath();
            //响应路径
            String url = scheme + "://" + localhost + ":" + serverPort + contextPath + "/upload/img/" + name;
            System.out.println("请求的路径为   ：" + url);
            map.put("url", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
