package com.baizhi.controller;


import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    //管理员登录
    public Map<String, Object> login(HttpServletRequest request, String username, String password, String code) {
        Map<String, Object> map = new HashMap<>();
        //通过requset获取session作用域  获取验证码
        String image = (String) request.getSession().getAttribute("image");
        //判断验证码是否正确
        if (image.equals(code)) {
            map = adminService.login(username, password);
        } else {
            map.put("msg", "验证码有误");
        }
        return map;
    }

    @RequestMapping("exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "jsp/login";
    }

}
