/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.springMVC_3_1.domain;

import java.util.Date;


/**
 * 
 * @author 周光明
 * @version $FileName: UserVO.java $Date: 2013-9-1 下午7:28:09 -0400 2013
 * @since 1.0
 * 
 */
public class UserVO {
	
	private int age;
	private String name;
	private Date birthday;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
