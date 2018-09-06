package com.jbit.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsRoleService;
import com.jbit.service.SmbmsUserService;
import com.jbit.utils.PaggingUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private SmbmsUserService smbmsUserService;
	@Resource
	private SmbmsRoleService smbmsRoleService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(SmbmsUser user, Model model, HttpSession session) {
		SmbmsUser smbmsUser = smbmsUserService.findLogin(user.getUsercode(),
				user.getUserpassword());
		if (smbmsUser != null) {
			session.setAttribute("user", smbmsUser);
			return "redirect:/jsp/frame.jsp";
		}
		model.addAttribute("error", "用户名或密码有误,请重新登录");
		return "login";
	}

	/**
	 * 用户退出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}

	/**
	 * 用户管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model,
			@RequestParam(required = false) String queryname,
			@RequestParam(required = false) Integer queryUserRole,
			@RequestParam(required = false) Integer pageIndex) {
		PaggingUtils utils = new PaggingUtils();
		if (pageIndex != null) {
			utils.setCurrentPageNo(pageIndex);
		}
		List<SmbmsUser> list = smbmsUserService.findUser(queryname,
				queryUserRole, utils);
		model.addAttribute("list", list); // 用户列表
		model.addAttribute("roleList", smbmsRoleService.findRole()); // 角色列表
		model.addAttribute("queryname", queryname);
		model.addAttribute("queryUserRole", queryUserRole);
		model.addAttribute("pagging", utils);
		return "jsp/userlist";
	}

	/**
	 * 验证用户编码是否存在
	 * 
	 * @return
	 */
	@RequestMapping(value = "/byCode")
	@ResponseBody
	public String byCode(String usercode) {
		SmbmsUser user = smbmsUserService.findUserByCode(usercode);
		if (user != null) {
			return "exist";
		}
		return "noexist";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(SmbmsUser user, HttpSession session) {
		SmbmsUser user2 = (SmbmsUser) session.getAttribute("user");
		// 设置添加者
		user.setCreatedby(user2.getId());
		int res = smbmsUserService.insertUser(user);
		if (res != 0) {
			return "redirect:/user/list";
		}
		return "jsp/useradd";
	}
	
	/**
	 * 查看用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/view/{id}/{method}")
	public String view(@PathVariable Long id,@PathVariable String method,Model model) {
		model.addAttribute("user", smbmsUserService.findUserById(id));
		if(method.equals("view")){
			return "jsp/userview";
		}
		return "jsp/usermodify";
	}
	
	/**
	 *删除用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		int res= smbmsUserService.delUser(id);
		if(res!=0){
			return "true";
		}
		return "false";
	}
	/**
	 *修改用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/upUser",method=RequestMethod.POST)
	public String upUser(SmbmsUser user,HttpSession session) {
		SmbmsUser user2 = (SmbmsUser) session.getAttribute("user");
		user.setModifyby(user2.getId());
		user.setModifydate(new Date());
		int res= smbmsUserService.updateUser(user);
		if(res!=0){
			return "redirect:/user/list";
		}
		return "redirect:/user/view/"+user.getId()+"/toup";
	}
}
