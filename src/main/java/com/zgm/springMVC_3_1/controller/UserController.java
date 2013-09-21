/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.springMVC_3_1.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import com.zgm.springMVC_3_1.domain.UserVO;

/**
 * 
 * @author 周光明
 * @version $FileName: ZyrController.java $Date: 2013-9-1 下午7:21:40 -0400 2013
 * @since 1.0
 * 
 */
@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
//	public String toAdd() {  // 返回值为的是视图逻辑名
	public ModelAndView toAdd() {  // 返回值为的是视图和模型对象
//	public void toAdd() {  //user/toAdd.jsp
		
		ModelAndView mav = new ModelAndView("to_add");
		int a = 0;
		return mav;
//		return "to_add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(UserVO userVO) {
		ModelAndView mav = new ModelAndView("add_success");
		mav.addObject("user", userVO);
		
		return mav;
	}
	
	@InitBinder
	public void initBind(ExtendedServletRequestDataBinder dataBinder) {
//	public void initBind(WebRequestDataBinder dataBinder) {
//		dataBinder.registerCustomEditor(requiredType, field, propertyEditor)
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
//		dataBinder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
//		dataBinder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
		dataBinder.registerCustomEditor(Date.class, "birthday2", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
//		dataBinder.registerCustomEditor(Date.class, "birthday2", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
}
