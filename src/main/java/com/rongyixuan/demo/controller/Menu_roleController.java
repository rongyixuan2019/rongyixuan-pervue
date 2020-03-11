package com.rongyixuan.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rongyixuan.demo.entity.Menu_role;
import com.rongyixuan.demo.service.IMenu_roleService;
import com.rongyixuan.demo.vo.ResultEntity;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RequestMapping("/menu_role")
public class Menu_roleController {

    @Resource
    private IMenu_roleService iMenu_roleService;

    @RequestMapping("/insert1")
    public ResultEntity insert1(Integer rid,Integer mids[]){
        try {
            iMenu_roleService.insertBatch(rid,mids);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.ok(false);
        }
        return ResultEntity.ok(true);
    }

    @RequestMapping("/insert")
    public ResultEntity insert(Integer rid,Integer mids[]){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("rid",rid);
        iMenu_roleService.remove(wrapper);
        if(mids!=null && mids.length>0) {
            //加入
            List<Menu_role> menuRoles = new ArrayList<>();
            for (Integer mid : mids) {
                Menu_role mr = new Menu_role();
                mr.setMid(mid);
                mr.setRid(rid);
                menuRoles.add(mr);
            }
            iMenu_roleService.saveBatch(menuRoles);

        }
        return ResultEntity.ok(true);
    }
}

