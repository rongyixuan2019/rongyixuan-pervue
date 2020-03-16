package com.rongyixuan.demo.controller;


import com.rongyixuan.demo.entity.Menu;
import com.rongyixuan.demo.entity.User;
import com.rongyixuan.demo.mapper.MenuMapper;
import com.rongyixuan.demo.service.IMenuService;
import com.rongyixuan.demo.vo.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private IMenuService iMenuService;

    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iMenuService.listMenus());
    }

    @RequestMapping("/listMenuByUserName")
    public ResultEntity listMenuByUserName(HttpServletRequest request){
       //获取session中的值
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            return ResultEntity.ok(iMenuService.listMenuByUserName(user.getUsername()));
        }else{
            return ResultEntity.ok(new ArrayList<Menu>());
        }
    }

}

