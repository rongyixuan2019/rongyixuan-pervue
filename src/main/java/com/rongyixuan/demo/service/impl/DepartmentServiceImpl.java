package com.rongyixuan.demo.service.impl;

import com.rongyixuan.demo.entity.Department;
import com.rongyixuan.demo.mapper.DepartmentMapper;
import com.rongyixuan.demo.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
