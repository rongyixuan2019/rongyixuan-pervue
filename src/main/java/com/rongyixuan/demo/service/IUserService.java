package com.rongyixuan.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rongyixuan.demo.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {

    /**
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page, UserVo userVo);
}
