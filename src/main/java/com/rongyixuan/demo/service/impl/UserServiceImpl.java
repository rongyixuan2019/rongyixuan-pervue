package com.rongyixuan.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.User;
import com.rongyixuan.demo.entity.UserVo;
import com.rongyixuan.demo.mapper.UserMapper;
import com.rongyixuan.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public IPage<User> selectPageVo(Page<?> page, UserVo userVo) {
        return userMapper.selectPageVo(page,userVo);
    }
}
