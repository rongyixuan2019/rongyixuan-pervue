package com.rongyixuan.demo.vo;

import com.rongyixuan.demo.entity.Goods;
import lombok.Data;

@Data
public class GoodsVo extends Goods {
    //区间查询
    private String p1;
    private String p2;
    //营销类型
    private String tnames;
    private String tids;
    //地区
    private String provinceName;
    private String cityName;
    private String districtName;
}
