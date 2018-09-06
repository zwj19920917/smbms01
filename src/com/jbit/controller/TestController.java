package com.jbit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsUserService;

@Controller
public class TestController {

	@Resource
	private SmbmsUserService smbmsUserService;
	

	@RequestMapping(value={"/view{id}.json","/view{id}.xml","/view{id}.html"})
	public SmbmsUser view(@PathVariable Long id){
		return smbmsUserService.findUserById(id);
	}
	
	/**
	 * String 返回页面 (文本)
	 * @return
	 */
//	@RequestMapping("/ajax")
//	@ResponseBody //通知MVC 控制器方法 使用非页面返回
//	public String ajax(){
//		System.out.println("ajax ....");
//		return "hello ajax";
//	}
//	@RequestMapping("/ajax")
//	@ResponseBody  //List ---> json
//	public List<SmbmsUser> ajax(){
//		List<SmbmsUser> list=smbmsUserService.findUser();
//		return list;
//	}
	
}
