package com.fixed.asset.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fixed.asset.model.Msg;
import com.fixed.asset.model.MsgStat;
import com.fixed.asset.model.User;
import com.fixed.asset.service.RoleService;
import com.fixed.asset.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
		
		@Autowired
		UserService userService;
	 	
		@Autowired
		RoleService roleSevice;
		
		@RequestMapping("/get")
	    public String get(Model model){
			
	        return "user_list";
	    }
	 	
	 	@RequestMapping(value = "/add",method=RequestMethod.GET)
	    public String toAdd(Model model){
	 		model.addAttribute("roles", roleSevice.getRoles(null));
	 		model.addAttribute("user", new User());
	        return "user_modify";
	    }
	 	
	 	/**
	 	 * 
	 	 * @param model
	 	 * @param user
	 	 * @param roleIds
	 	 * @return
	 	 */
	 	@RequestMapping(value = "/add",method=RequestMethod.POST)
	 	@ResponseBody
	    public String add(Model model,User user,String [] roleIds){
	 		try {
	 			userService.add(user, roleIds);
	 			return new Msg(MsgStat.success,"添加用户成功！").toJson();
	 		}catch(Exception dae) {
	 			return new Msg(MsgStat.error,"添加用户失败！",dae.getMessage()).toJson();
	 		}
	    }
}