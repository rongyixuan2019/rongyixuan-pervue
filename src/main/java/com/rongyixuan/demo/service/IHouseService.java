package com.rongyixuan.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chj
 * @since 2020-03-15
 */
public interface IHouseService extends IService<House> {

    IPage<House> selectPageVo(Page<House> page, House house);
}
