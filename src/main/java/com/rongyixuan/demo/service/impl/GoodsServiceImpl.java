package com.rongyixuan.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Goods;
import com.rongyixuan.demo.entity.GoodsVo;
import com.rongyixuan.demo.mapper.GoodsMapper;
import com.rongyixuan.demo.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xc
 * @since 2020-03-13
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public IPage<GoodsVo> selectVos(Page page, GoodsVo goodsVo) {
        return goodsMapper.selectVos(page,goodsVo);
    }
}
