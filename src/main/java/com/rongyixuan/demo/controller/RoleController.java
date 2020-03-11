package com.rongyixuan.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Role;
import com.rongyixuan.demo.entity.User;
import com.rongyixuan.demo.entity.UserVo;
import com.rongyixuan.demo.service.IMenu_roleService;
import com.rongyixuan.demo.service.IRoleService;
import com.rongyixuan.demo.vo.Result;
import com.rongyixuan.demo.vo.ResultEntity;
import com.rongyixuan.demo.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;
    @Resource
    private IMenu_roleService iMenu_roleService;


    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iRoleService.list());
    }

    @RequestMapping("/select")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size, RoleVO roleVO){
        Page<RoleVO> page = new Page<>(current,size);
        /*QueryWrapper queryWrapper =new QueryWrapper();
        Page pageInfo = iUserService.page(page, queryWrapper);*/
        //自定义查询分页实现
        IPage<RoleVO> pageInfo = iRoleService.selectPageVo(page, roleVO);
        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("deletes")
    public ResultEntity deletes(Integer ids[]){
        for (Integer id : ids){
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("rid",id);
            iMenu_roleService.remove(wrapper);
        }

        boolean flag = iRoleService.removeByIds(Arrays.asList(ids)) ;
        return ResultEntity.ok(flag);
    }

    @RequestMapping("update")
    public ResultEntity update(@RequestBody Role role){
        boolean flag = iRoleService.updateById(role);
        return ResultEntity.ok(flag);
    }
}

