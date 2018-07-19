package com.firolypro.services.impl;

import com.firolypro.dataobj.Users;
import com.firolypro.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserService userService;



	@Test
	public void findAllTest() {
		List<Users> result = userService.findAll();

		System.out.println("现有的数据有："+result.toString());
	}

	@Test
	public void saveTest() {
//		User user = new User();
//		user.setIduser(5);
//		user.setUsername("addtest4");
//		user.setPassword("12");
//
//
////		User user = new User("addtest3","21");
//		User result = userService.save(user);
//		Assert.assertNotNull(result);

		Users user = new Users();
//		user.setIduser(5);
		user.setName("addtest4");
		user.setPassword("12");


//		User user = new User("addtest3","21");
		Users result = userService.save(user);
		Assert.assertNotNull(result);
	}



	@Test
	public void findOneTest() {
		Users result = userService.findOneById(3);
		System.out.println("查询到的结果 = "+result.toString());
		Assert.assertNotNull(result);
	}

	@Test
	public void delectByIdTest() {
		userService.delectById(4);
		System.out.println("delect Success");
	}


	@Test
	public void updateTest() {
		userService.update(3,"testnew","");
	}
}