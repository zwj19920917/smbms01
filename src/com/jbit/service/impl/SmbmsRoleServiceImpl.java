package com.jbit.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jbit.dao.SmbmsRoleDao;
import com.jbit.entity.SmbmsRole;
import com.jbit.service.SmbmsRoleService;

@Service("smbmsRoleService")
public class SmbmsRoleServiceImpl implements SmbmsRoleService {

	@Resource
	private SmbmsRoleDao smbmsRoleDao;
	
	public List<SmbmsRole> findRole() {
		return smbmsRoleDao.findRole();
	}

}
