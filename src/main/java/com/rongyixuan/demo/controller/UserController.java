package com.rongyixuan.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.rongyixuan.demo.entity.User;
import com.rongyixuan.demo.entity.UserVo;
import com.rongyixuan.demo.service.IUserService;
import com.rongyixuan.demo.vo.Result;
import com.rongyixuan.demo.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size, UserVo userVo){
        Page<User> page = new Page<>(current,size);
        /*QueryWrapper queryWrapper =new QueryWrapper();
        Page pageInfo = iUserService.page(page, queryWrapper);*/
        //自定义查询分页实现
        IPage<User> pageInfo = iUserService.selectPageVo(page, userVo);
        return Result.success(pageInfo);
    }

    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]){
        boolean flag = iUserService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }
    @RequestMapping("/insert")
     public ResultEntity insert(@RequestBody User entity){
        boolean flag = iUserService.save(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/update")
    public ResultEntity update(@RequestBody User entity){
        boolean flag = iUserService.updateById(entity);
        return ResultEntity.ok(flag);
    }
}

