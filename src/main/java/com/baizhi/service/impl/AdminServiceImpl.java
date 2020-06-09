package com.baizhi.service.impl;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service            //交给spring容器管理
@Transactional      //事务控制
public class AdminServiceImpl implements AdminService {
    //注入DAO
    @Autowired
    private AdminDAO adminDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    //登录
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        Admin admin = adminDAO.queryByUserName(username);
        //判断用户是否为空
        if (admin == null) {
            map.put("msg", "用户名有误");
        } else {
            //判断用户密码
            if (admin.getPassword().equals(password)) {
                map.put("msg", null);
            } else {
                map.put("msg", "密码有误");
            }
        }
        return map;
    }
}
