package com.jbit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbit.entity.SmbmsRole;
import com.jbit.service.SmbmsRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private SmbmsRoleService smbmsRoleService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<SmbmsRole> list(){
		return smbmsRoleService.findRole();
	}
	
}
