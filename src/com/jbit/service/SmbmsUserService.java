package com.jbit.service;

import java.util.List;

import com.jbit.entity.SmbmsUser;
import com.jbit.utils.PaggingUtils;

public interface SmbmsUserService {
	
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
    SmbmsUser findUserById(Long id);
	 /**
     * 用户登录
     * @param usercode
     * @param userpassword
     * @return
     */
    SmbmsUser findLogin(String usercode ,String userpassword);
    
    /**
     * 查询所有用户
     * @param queryUserRole 
     * @param queryname 
     * @return
     */
    List<SmbmsUser> findUser(String queryname, Integer queryUserRole,PaggingUtils pagging);
    
    /**
     * 用户编码查询
     * @return
     */
    SmbmsUser findUserByCode(String usercode);
    
    /**
     * 用户添加
     * @param user
     * @return
     */
    int insertUser(SmbmsUser user);
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    int delUser(Long id);
    
    /**
     * 修改用户
     * @param id
     * @return
     */
    int updateUser(SmbmsUser user);
}


