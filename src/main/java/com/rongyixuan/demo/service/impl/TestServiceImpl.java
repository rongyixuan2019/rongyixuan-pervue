package com.rongyixuan.demo.service.impl;

import com.rongyixuan.demo.entity.Test;
import com.rongyixuan.demo.mapper.TestMapper;
import com.rongyixuan.demo.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chj
 * @since 2020-03-03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
