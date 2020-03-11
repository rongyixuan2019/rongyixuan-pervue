package com.rongyixuan.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rongyixuan.demo.vo.RoleVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
public interface IRoleService extends IService<Role> {

    IPage<RoleVO> selectPageVo(Page<?> page, RoleVO roleVO);

}
