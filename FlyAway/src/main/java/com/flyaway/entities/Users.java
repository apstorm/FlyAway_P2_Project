package com.flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10,name = "user_id")
	private int id;
	
	
	@Column(nullable = false,length = 100)
	private String name;
	
	
	@Column(unique = true,nullable = false,length = 100)
	private String email;
	
	
	@Column(nullable = false,length = 150)
	private String userPassword;
	
	
	@Column(unique=true,nullable = false,length = 10)
	private String phone;
	
	
	@Column(nullable = false,length = 3)
	private int age;
	

	@Column(length = 100)
	private String userType;
	
	public Users() {
		
	}

	

	public Users(String name, String email, String userPassword, String phone, int age, String userType) {
		super();
		this.name = name;
		this.email = email;
		this.userPassword = userPassword;
		this.phone = phone;
		this.age = age;
		this.userType = userType;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", userType=" + userType + "]";
	}

}
