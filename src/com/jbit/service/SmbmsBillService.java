package com.jbit.service;

import com.jbit.entity.SmbmsBill;
import com.jbit.utils.PaggingUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
public interface SmbmsBillService {
    List<SmbmsBill> selsctBillList(Integer queryProviderId, String queryProductName, Integer queryIsPayment,PaggingUtils pagging);
    //添加订单
    int insertbill(SmbmsBill bill);
    //删除订单
    int delbill(Long id);
    //按id查询订单
    SmbmsBill selectByPrimaryKey(Long id);
    //修改订单
    int updatebill(SmbmsBill bill);
}
