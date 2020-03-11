package com.rongyixuan.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Menu;
import com.rongyixuan.demo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.rongyixuan.demo.vo.RoleVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {

    //分页查询
    IPage<RoleVO> selectPageVo(Page<?> page, RoleVO roleVO);
}
