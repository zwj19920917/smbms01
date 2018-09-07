package com.jbit.service;

import com.jbit.entity.SmbmsProvider;

import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
public interface SmbmsProviderService {
    //供应商管理
    List<SmbmsProvider> selectProviderLists(String queryProCode,String queryProName);
    //查询全部供应商
    List<SmbmsProvider> selectProviderList();
    //按id查找供应商
    SmbmsProvider selectByPrimaryKey(Long id);
    //修改供应商
    int updateProvider(SmbmsProvider provider);
}
