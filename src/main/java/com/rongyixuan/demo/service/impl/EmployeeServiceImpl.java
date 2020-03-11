package com.rongyixuan.demo.service.impl;

import com.rongyixuan.demo.entity.Employee;
import com.rongyixuan.demo.mapper.EmployeeMapper;
import com.rongyixuan.demo.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
