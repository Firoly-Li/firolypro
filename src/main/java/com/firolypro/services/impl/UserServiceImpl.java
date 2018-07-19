package com.firolypro.services.impl;

import com.firolypro.dataobj.Users;
import com.firolypro.repository.UserDao;
import com.firolypro.repository.UsersRepository;
import com.firolypro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {


	@Autowired
	UsersRepository repository;


	@Autowired
	UserDao userDao;

	@Override
	public List<Users> findAll(){
		return repository.findAll();
	}


	@Override
	public Users save(Users user) {
		if(user != null) {
			repository.save(user);
		}
		return user;
	}


//	@Override
//	public Users saves(Users users) { return repository.save(users);}


	@Override
	public Users findOneById(int iduser){
		Users result = repository.findById(iduser).get();;
		return result;
	}

	@Override
	public Users update(int id,String newname,String password) {
		Users result = repository.findById(id).get();
		if(newname !="") {
			result.setUsername("newtest");
		}
		if(password!="") {
			result.setPassword("123test");
		}
		repository.save(result);
		return result;
	}

	@Override
	public void delectById(int id) {
		repository.deleteById(id);
		System.out.println("success");
	}
}
