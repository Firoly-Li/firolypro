package com.firolypro.controller;


import com.firolypro.dataobj.Users;
import com.firolypro.repository.UserDao;
import com.firolypro.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 操作数据库的controller，这里是一些对数据库操作的接口开放。
 */

@Api("这个是操作数据库中user表的接口")
@CrossOrigin(origins = {"http://localhost:8080","null"})
@RestController
public class UserController {

	@Resource
//	private UserRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;


	/**
	 * 获取所有的user
	 * @return
	 */

	@ApiOperation(value = "获取所有的用户列表",notes = "")
	@GetMapping("/test")
	public List<Users> getList() {
//		return repository.findAll();
		System.out.println(userService.findAll().toString());
		return userService.findAll();
	}

	/**
	 * 添加一个user
	 */


//	@RequestMapping("/loginer")
//	@ResponseBody
//	public String loginer(@RequestBody String body) {
//		JSONObject obj = new JSONObject(body);
//		String name = obj.getString("name");
//		String password = obj.getString("password");
//		User result = userDao.findOneByNameAndPassword(name, password);
//
//		if (result == null) {
//			return "登陆失败";
//		} else {
//			return "登陆成功";
//		}
//	}

}
