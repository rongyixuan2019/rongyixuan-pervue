package com.rongyixuan.demo.controller;


import com.rongyixuan.demo.service.IGtypeService;
import com.rongyixuan.demo.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xc
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/gtype")
public class GtypeController {
    @Autowired
    private IGtypeService iGtypeService;
    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iGtypeService.list());
    }
}

