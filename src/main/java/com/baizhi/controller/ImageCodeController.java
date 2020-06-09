package com.baizhi.controller;

import com.baizhi.util.ValidateImageCodeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("code")
public class ImageCodeController {

    @RequestMapping("getCode")
    public void code(HttpServletResponse response, HttpSession session) {

        //1、绘制验证码字符
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //2、通过字符绘制生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //3、通过图片的输出流  写到封面
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", servletOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //将获取的验证码存到session作用域
        session.setAttribute("image", securityCode);
    }
}
