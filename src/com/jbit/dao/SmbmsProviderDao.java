package com.jbit.dao;

import com.jbit.entity.SmbmsProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsProviderDao {
    //按id查找供应商
    SmbmsProvider selectByPrimaryKey(Long id);
    //供应商管理
    List<SmbmsProvider> selectProviderLists(@Param("queryProCode") String queryProCode,@Param("queryProName")String queryProName);
    //查询全部供应商
    List<SmbmsProvider> selectProviderList();
    //修改供应商
    int updateProvider(SmbmsProvider provider);
    //查看供应商下有多少条订单
    int selectcount(long id);
    //删除供应商
    int deleteProvider(Long id);
    //增加供应商
    int insertProvider(SmbmsProvider provider);
}