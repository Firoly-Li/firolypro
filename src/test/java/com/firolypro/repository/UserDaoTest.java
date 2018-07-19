package com.firolypro.repository;

import com.firolypro.dataobj.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void findOneByNameAndPassword() {
		Users user = userDao.findOneByNameAndPassword("test1","123");
		System.out.println("请求的数据 = "+user.toString());

	}

	@Test
	public void addUser() {
//		Users user = userDao.addUser("teste","123");
	}

}