package com.rongyixuan.demo.service.impl;

import com.rongyixuan.demo.entity.Nation;
import com.rongyixuan.demo.entity.NationVo;
import com.rongyixuan.demo.mapper.NationMapper;
import com.rongyixuan.demo.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author chj
 * @since 2020-03-04
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {
    @Resource
    private NationMapper nationMapper;

    @Override
    public List<NationVo> findAll() {
        return nationMapper.findAll();
    }
}
