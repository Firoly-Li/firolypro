package com.firolypro.services;

import com.firolypro.dataobj.Users;

import java.util.List;


public interface UserService {

	//查找所有的数据
	List<Users> findAll();

	//添加一个user  增
	Users save(Users user);

	//查找一个特定的实例  查
	Users findOneById(int id);

	//修改一个实例的属性   改
	Users update(int id,String newname,String password);

	//删除指定实例      删
	void delectById(int id);

}