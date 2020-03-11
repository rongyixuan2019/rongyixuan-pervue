package com.rongyixuan.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rongyixuan.demo.entity.Menu;

import java.util.List;

public interface IMenuService extends IService <Menu>{

    //查询所有的结果
    List<Menu> listMenus();

    //根据姓名查资源
    List<Menu> listMenuByUserName(String userName);
}
