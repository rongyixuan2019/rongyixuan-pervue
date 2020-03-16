package com.rongyixuan.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chj
 * @since 2020-03-15
 */
public interface HouseMapper extends BaseMapper<House> {

    IPage<House> selectPageVo(Page<House> page, House house);
}
