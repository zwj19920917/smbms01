package com.jbit.dao;

import com.jbit.entity.SmbmsProvider;

import java.util.List;

public interface SmbmsProviderDao {
    SmbmsProvider selectByPrimaryKey(Long id);

    List<SmbmsProvider> selectProviderList();
}