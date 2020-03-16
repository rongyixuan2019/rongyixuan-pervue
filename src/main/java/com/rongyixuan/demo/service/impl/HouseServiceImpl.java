package com.rongyixuan.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.House;
import com.rongyixuan.demo.mapper.HouseMapper;
import com.rongyixuan.demo.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chj
 * @since 2020-03-15
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

    @Resource
    private  HouseMapper houseMapper;
    @Override
    public IPage<House> selectPageVo(Page<House> page, House house) {
        return houseMapper.selectPageVo(page,house);
    }
}
