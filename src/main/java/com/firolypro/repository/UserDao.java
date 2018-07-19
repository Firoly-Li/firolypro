package com.firolypro.repository;

import com.firolypro.dataobj.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * 使用@Query来自定义查询条件
 */
public interface UserDao extends Repository<Users,Integer> {
	@Query("select p from Users p where name=:username and  password=:password")
	Users findOneByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
