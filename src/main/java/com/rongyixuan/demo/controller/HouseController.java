package com.rongyixuan.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.House;
import com.rongyixuan.demo.entity.User;
import com.rongyixuan.demo.entity.UserVo;
import com.rongyixuan.demo.service.IHouseService;
import com.rongyixuan.demo.service.IUserService;
import com.rongyixuan.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chj
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private IHouseService iHouseService;

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size, House house){
        Page<House> page = new Page<>(current,size);
        //自定义查询分页实现
        IPage<House> pageInfo = iHouseService.selectPageVo(page, house);
        return Result.success(pageInfo);
    }
}

