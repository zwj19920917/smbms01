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
    @Override
    public List<SmbmsProvider> selectProviderList() {
        return smbmsProviderDao.selectProviderList();
    }
}
