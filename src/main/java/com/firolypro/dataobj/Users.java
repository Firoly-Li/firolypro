package com.firolypro.dataobj;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicUpdate  //自动更新数据
public class Users {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idusers;

	private String name;

	private String password;

	private String username;

	private String description;

	public Users() {}

	public Users(String username, String password) {
		this.name = username;
		this.password = password;
	}

	public int getIduser() {
		return idusers;
	}

	public void setIduser(int idusers) {
		this.idusers = idusers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "username = "+name+"、"+"password  = "+password+";";
	}

}
