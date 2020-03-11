package com.rongyixuan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rongyixuan.demo.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    //查询所有的结果
    List<Menu> listMenus();
//根据姓名查资源
    List<Menu> listMenuByUserName(String userName);
}
