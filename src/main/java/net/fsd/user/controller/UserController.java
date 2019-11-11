package net.fsd.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.fsd.comm.BaseController;
import net.fsd.entity.FSDUser;
import net.fsd.user.service.IUserService;

@RestController

@RequestMapping("/user")


public class UserController extends BaseController {
	@Autowired
	IUserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		return "this is the root of /user home!";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map addUser(FSDUser u) throws JsonProcessingException {
		FSDUser user = userService.addUser(u);
		Map map = composeReturnMap();
		map.put("id", user.getId());
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Map updateUser(FSDUser u) throws JsonProcessingException {
		userService.updateUser(u);
		return composeReturnMap();
	}

	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public Map updatePwd(String pwd) {
		userService.updatePwd(pwd);
		return composeReturnMap();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Map deleteUser(long userId) {
		userService.deleteUser(userId);
		return composeReturnMap();
	}

	// @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public Map deleteUserGet(@PathVariable long userId) {
		userService.deleteUser(userId);
		return composeReturnMap();
	}

	@RequestMapping(value = "/finduser", method = RequestMethod.POST)
	// @ResponseBody
	public FSDUser findUser(long userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = "/listuser", method = RequestMethod.POST)
	// @ResponseBody
	public List<FSDUser> listUser() {
		List list = userService.listUser();
		return list;
	}

	@RequestMapping(value = "/listmentor", method = RequestMethod.POST)
	// @ResponseBody
	public List<FSDUser> listMentor() {
		return userService.listMentor();
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public Map curUserInfo() {
		String curUser = "";
		Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principl instanceof UserDetails) {
			curUser = ((UserDetails) principl).getUsername();
		} else {
			curUser = principl.toString();
		}

		Map map = composeReturnMap();
		map.put("curUser", curUser);

		return map;
	}

}
