package com.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jbit.entity.SmbmsUser;

public interface SmbmsUserDao {
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
    SmbmsUser findUserById(Long id);
    
    /**
     * 查询所有用户
     * @param queryUserRole 
     * @param queryname 
     * @return
     */
    List<SmbmsUser> findUser(@Param("queryname") String queryname,@Param("queryUserRole") Integer queryUserRole,@Param("startPage")Integer startPage,@Param("endPage")Integer endPage);
    
    
    /**
     * 总条数
     * @return
     */
    int totalCount(@Param("queryname") String queryname,@Param("queryUserRole") Integer queryUserRole);
    
    /**
     * 用户登录
     * @param usercode
     * @param userpassword
     * @return
     */
    SmbmsUser findLogin(@Param("usercode") String usercode ,@Param("userpassword") String userpassword);
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