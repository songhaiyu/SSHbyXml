package com.shy.entity;

import java.io.Serializable;


public class Userinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6102003222041178541L;
	
	

	
	 public Userinfo() {
		super();
	}
	/**用户id*/  
    private Integer id;  
    /**用户名*/  
    private String uname;  
    /**性别*/  
    private String sex;  
    /**密码*/  
    private String password;  
    /**电话号码*/  
    private String telphone;  
    /**住址*/  
    private String address;




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
    
	
	
}
