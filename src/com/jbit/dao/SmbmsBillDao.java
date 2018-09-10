package com.jbit.dao;

import com.jbit.entity.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsBillDao {
    //按id查询订单
    SmbmsBill selectByPrimaryKey(Long id);
    //订单管理
    List<SmbmsBill> selsctBillList(@Param("queryProviderId") Integer queryProviderId, @Param("queryProductName") String queryProductName, @Param("queryIsPayment") Integer queryIsPayment,@Param("startPage")Integer startPage,@Param("endPage")Integer endPage);
    //添加订单
    int insertbill(SmbmsBill bill);
    //删除订单
    int delbill(Long id);
    //查询订单条数
    int selecttotalCount(@Param("queryProviderId") Integer queryProviderId, @Param("queryProductName") String queryProductName, @Param("queryIsPayment") Integer queryIsPayment);
    //修改订单
    int updatebill(SmbmsBill bill);
}