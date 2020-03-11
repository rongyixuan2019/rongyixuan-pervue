package com.rongyixuan.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Role;
import com.rongyixuan.demo.mapper.RoleMapper;
import com.rongyixuan.demo.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rongyixuan.demo.vo.RoleVO;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public IPage<RoleVO> selectPageVo(Page<?> page, RoleVO roleVO) {
        return roleMapper.selectPageVo(page,roleVO);
    }
}
