package com.rongyixuan.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rongyixuan.demo.entity.UserVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageVo(Page<?> page, UserVo userVo);
}
