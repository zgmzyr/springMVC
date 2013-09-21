/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.expertSpringMVCAndWebFlow._4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 
 * @author 周光明
 * @version $FileName: HomeController.java $Date: 2013-8-9 下午10:35:25 -0400 2013
 * @since 1.0
 * 
 */
public class HomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("zyr", "zgmzyr");
		modelAndView.setViewName("zyr");

		return modelAndView;
	}

}
