package com.jbit.dao;

import com.jbit.entity.SmbmsAddress;

public interface SmbmsAddressDao {
    SmbmsAddress selectByPrimaryKey(Long id);
}