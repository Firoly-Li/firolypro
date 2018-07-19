package com.firolypro.controller;


import com.firolypro.dataobj.Users;
import com.firolypro.repository.UserDao;
import com.firolypro.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 这个是系统登陆的的controller，通过这个系统可以完成登陆和注册功能
 */
 
@CrossOrigin

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserDao userDao;


	@Autowired
	private UserService userService;


	/**
	 * 页面展示，可以通过地址中的值跳转到相应的页面
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/{page}", method=RequestMethod.GET)
	public String showPage(@PathVariable("page") String page) {
		System.out.println(page);
		return page;
	}

	/**
	 * 登陆
	 * @param body
	 * @return
	 */
	@RequestMapping("/loginer")
	@ResponseBody
	public String loginer(@RequestBody String body) {
		System.out.println("请求体" +
				"" +
				"= "+body);
		JSONObject obj = new JSONObject(body);
		String name = obj.getString("name");
		String password = obj.getString("password");
		Users result = userDao.findOneByNameAndPassword(name, password);

		//判断result的状态
		if (result == null) {
			System.out.println(name+":"+"登陆失败");
			return "登陆失败";
		} else {
			System.out.println(name+":"+"登陆成功");
			return "登陆成功";
		}
	}


	/**
	 * 注册
	 * @RequestMapping("/register") 这个注解中的register对应的是regist.html页面的功能，但是由于
	 * showPage方法的原因，所以这个功能部分的地址不能和页面地址一样，不然会报错
	 * @param body
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String regist(@RequestBody String body) {
		JSONObject obj = new JSONObject(body);
		String name = obj.getString("name");
		String password = obj.getString("password");
		Users user = new Users(name,password);
		Users result = userDao.findOneByNameAndPassword(name, password);

		String back = "";
		//判断result的状态
		if (result == null) {
			Users results = userService.save(user);
			//判断result的状态
			if (results != null) {
				System.out.println(name+":"+"注册成功");
				back =  "注册成功";
			}
		} else {
			System.out.println(name+":"+"用户已存在，请重新注册");
			back =  "用户已存在，请重新注册";
		}
		return back;

	}


}
