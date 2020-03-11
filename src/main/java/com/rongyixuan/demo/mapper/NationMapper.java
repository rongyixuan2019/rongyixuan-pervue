package com.rongyixuan.demo.mapper;

import com.rongyixuan.demo.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rongyixuan.demo.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 Mapper 接口
 * </p>
 *
 * @author chj
 * @since 2020-03-04
 */
public interface NationMapper extends BaseMapper<Nation> {
    /**
     * 查询所有的数据
     * @return
     */
    List<NationVo> findAll();
}
