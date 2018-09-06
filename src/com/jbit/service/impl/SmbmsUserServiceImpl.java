package com.jbit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jbit.dao.SmbmsUserDao;
import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsUserService;
import com.jbit.utils.PaggingUtils;

@Service("smbmsUserService")
public class SmbmsUserServiceImpl implements SmbmsUserService {

	@Resource
	private SmbmsUserDao smbmsUserDao;
	
	public SmbmsUser findUserById(Long id) {
		return smbmsUserDao.findUserById(id);
	}
	
	public List<SmbmsUser> findUser(String queryname, Integer queryUserRole,PaggingUtils pagging) {
		//初始化分页组件
		pagging.initPagging(smbmsUserDao.totalCount(queryname, queryUserRole));
		return smbmsUserDao.findUser(queryname,queryUserRole,pagging.startPage(),pagging.endPage());
	}
	
	public SmbmsUser findLogin(String usercode, String userpassword) {
		return smbmsUserDao.findLogin(usercode, userpassword);
	}
	
	public SmbmsUser findUserByCode(String usercode) {
		return smbmsUserDao.findUserByCode(usercode);
	}

	public int insertUser(SmbmsUser user) {
		return smbmsUserDao.insertUser(user);
	}
	
	public int delUser(Long id) {
		return smbmsUserDao.delUser(id);
	}
	
	public int updateUser(SmbmsUser user) {
		return smbmsUserDao.updateUser(user);
	}
}
