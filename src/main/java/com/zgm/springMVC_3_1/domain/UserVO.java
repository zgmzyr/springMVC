/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.springMVC_3_1.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


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
	/**
	 * 已婚
	 */
	private boolean married;
	/**
	 * 爱好
	 */
	private List<String> like;
	/**
	 * 国籍
	 */
	private String nationality;
	/**
	 * 地址
	 */
	private AddressVO addressVO;
	
	private List<FriendVO> friendList;

//	@NotEmpty
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@NotBlank(message = "姓名不能为空")
	@Size(min = 2, max = 4, message = "姓名长度大于1小于5")
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

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public List<String> getLike() {
		return like;
	}

	public String getNationality() {
		return nationality;
	}

	public void setLike(List<String> like) {
		this.like = like;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<FriendVO> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<FriendVO> friendList) {
		this.friendList = friendList;
	}

	@Override
	public String toString() {
		
		//TODO
		return this.name;
	}
}
