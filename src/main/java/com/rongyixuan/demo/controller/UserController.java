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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
//测试登陆
    @RequestMapping("/login1")
    public ResultEntity login(HttpServletRequest request, String userName, String password){
        //获取session
        HttpSession session = request.getSession();
        //输出session的id
        System.out.println(session.getId()+"@@@@@@@@@@@@@@@@@@@@@@@");
        //定义查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        //username名称是唯一
        queryWrapper.eq("username",userName);
        //获取实体对象
        User entity = iUserService.getOne(queryWrapper);
        //判断查询结果
        if(entity!=null){
            //判断密码
            if(entity.getPassword().equals(password)){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001,"用户名或密码错误");
    }

    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,@RequestBody User user){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        System.out.println(session.getId()+"@@@@@@@@@@@@@@@@@@@@@@@");
        //定义查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        //username名称是唯一
        queryWrapper.eq("username",user.getUsername());
        //获取实体对象
        User entity = iUserService.getOne(queryWrapper);
        //判断查询结果
        if(entity!=null){
            //判断密码
            if(entity.getPassword().equals(user.getPassword())){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001,"用户名或密码错误");
    }
    @RequestMapping("loginOut")
    public ResultEntity loginOut(HttpServletRequest request){
       HttpSession session = request.getSession();
        //获取session的id
        System.out.println(session.getId()+"---------------");
        session.removeAttribute("user");
        return ResultEntity.ok(true);
    }
}

