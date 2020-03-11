package com.rongyixuan.demo.controller;


import com.rongyixuan.demo.mapper.MenuMapper;
import com.rongyixuan.demo.service.IMenuService;
import com.rongyixuan.demo.vo.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public ResultEntity listMenuByUserName(@RequestParam(defaultValue = "lisi") String userName){
        return ResultEntity.ok(iMenuService.listMenuByUserName(userName));
    }

}

