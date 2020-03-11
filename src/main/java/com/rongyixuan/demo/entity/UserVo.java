package com.rongyixuan.demo.entity;

import lombok.Data;

@Data
public class UserVo extends User {
    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;

    //扩展角色表的属性
    private String rids;
    private String rnames;
    private String rnameZhs;
}
