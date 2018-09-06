package com.jbit.dao;

import java.util.List;

import com.jbit.entity.SmbmsRole;

public interface SmbmsRoleDao {
    SmbmsRole selectByPrimaryKey(Long id);
    
    /**
     * 查询所有角色信息
     * @return
     */
    List<SmbmsRole> findRole();
}