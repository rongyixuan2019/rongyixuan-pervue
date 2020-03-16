package com.rongyixuan.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongyixuan.demo.entity.Goods;
import com.rongyixuan.demo.entity.GoodsVo;
import com.rongyixuan.demo.entity.Goods_type;
import com.rongyixuan.demo.service.IGoodsService;
import com.rongyixuan.demo.service.IGoods_typeService;
import com.rongyixuan.demo.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xc
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;

    @Autowired
    private IGoods_typeService iGoods_typeService;
    /**
     * 列表
     * @param current
     * @param size
     * @param goodsVo
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity selectVos(@RequestParam(defaultValue = "1") long current, @RequestParam(defaultValue = "3") long size, GoodsVo goodsVo){
        Page page=new Page(current,size);
        IPage<GoodsVo> goodsVoIPage = iGoodsService.selectVos(page, goodsVo);
        return ResultEntity.ok(goodsVoIPage);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/deletes")
    public ResultEntity deletes(Integer ids[]){
        boolean b = iGoodsService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(b);
    }
    /**
     * 添加
     */
    @RequestMapping("/insert")
    public ResultEntity insert(Goods goods,Integer []typeids){
        if (goods!=null) {
            goods.setCreatedtime(new Date());
            boolean b = iGoodsService.save(goods);
            if (b){
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("name",goods.getName());
                Goods one = iGoodsService.getOne(wrapper);
                if (one!=null){
                    Goods_type goods_type=new Goods_type();
                    goods_type.setGid(one.getId());
                    for (Integer tid:typeids) {
                        goods_type.setTid(tid);
                        iGoods_typeService.save(goods_type);
                    }
                    return ResultEntity.ok(true);
                }
            }
        }

        return ResultEntity.error();
    }
    @RequestMapping("/update")
    public ResultEntity update(Goods goods,Integer []typeids){
        if (goods!=null) {
            boolean b = iGoodsService.updateById(goods);
            if (b){
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("gid",goods.getId());
                boolean b1 = iGoods_typeService.remove(wrapper);
                Goods_type goods_type=new Goods_type();
                if (b1){
                    goods_type.setGid(goods.getId());
                    for (Integer tid:typeids) {
                        goods_type.setTid(tid);
                        iGoods_typeService.save(goods_type);
                    }
                    return ResultEntity.ok(true);
                }
            }
        }

        return ResultEntity.error();
    }
}

