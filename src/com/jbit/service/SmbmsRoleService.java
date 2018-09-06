package com.jbit.service;

import java.util.List;

import com.jbit.entity.SmbmsRole;

public interface SmbmsRoleService {

	 /**
     * 查询所有角色信息
     * @return
     */
    List<SmbmsRole> findRole();
    
}
