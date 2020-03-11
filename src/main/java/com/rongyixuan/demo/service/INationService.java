package com.rongyixuan.demo.service;

import com.rongyixuan.demo.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rongyixuan.demo.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务类
 * </p>
 *
 * @author chj
 * @since 2020-03-04
 */
public interface INationService extends IService<Nation> {
    /**
     * 查询所有的数据
     * @return
     */
    List<NationVo> findAll();
}
