package com.jbit.service.impl;

import com.jbit.dao.SmbmsProviderDao;
import com.jbit.entity.SmbmsProvider;
import com.jbit.service.SmbmsProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
@Service("smbmsProviderService")
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
    @Resource
    private SmbmsProviderDao smbmsProviderDao;
    //供应商管理
    @Override
    public List<SmbmsProvider> selectProviderLists(String queryProCode,String queryProName) {
        return smbmsProviderDao.selectProviderLists(queryProCode,queryProName);
    }
    //查全部供应商
    @Override
    public List<SmbmsProvider> selectProviderList() {
        return smbmsProviderDao.selectProviderList();
    }
    //按id查找供应商
    @Override
    public SmbmsProvider selectByPrimaryKey(Long id) {
        return smbmsProviderDao.selectByPrimaryKey(id);
    }
    //修改供应商
    @Override
    public int updateProvider(SmbmsProvider provider) {
        return smbmsProviderDao.updateProvider(provider);
    }
}
