package com.rongyixuan.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rongyixuan.demo.entity.Menu;
import com.rongyixuan.demo.mapper.MenuMapper;
import com.rongyixuan.demo.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
   @Resource
   private MenuMapper menuMapper;
    @Override
    public List<Menu> listMenus() {
        return menuMapper.listMenus();
    }

    @Override
    public List<Menu> listMenuByUserName(String userName) {
        return menuMapper.listMenuByUserName(userName);
    }
}
