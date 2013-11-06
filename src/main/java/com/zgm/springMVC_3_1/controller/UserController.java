/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.springMVC_3_1.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zgm.springMVC_3_1.domain.FriendVO;
import com.zgm.springMVC_3_1.domain.UserVO;

/**
 * 
 * @author 周光明
 * @version $FileName: ZyrController.java $Date: 2013-9-2 下午7:21:40 -0400 2013
 * @since 1.0
 * 
 */
@Controller
@RequestMapping("user")
public class UserController {

	//访问url：http://localhost/项目上下文/user/toAdd
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	// public String toAdd() { // 返回值为逻辑视图名
	public ModelAndView toAdd(UserVO userVO) { // 返回值为视图和模型对象
	// public void toAdd() { //返回为void时，视图的解析按照默认规则解析：user/toAdd.jsp

		ModelAndView mav = new ModelAndView("to_add");
		mav.addObject("command", userVO);//TODO 
		userVO.setName("zyr");
		userVO.setMarried(true);
		List<String> like = new ArrayList<String>();
		like.add("sport");
		like.add("sing");
		userVO.setLike(like);
		
		Map<String, String> likeMap = new HashMap<String, String>();
		likeMap.put("sport", "运动");
		likeMap.put("sing", "唱歌");
		likeMap.put("dance", "跳舞");
		mav.addObject("likeMap", likeMap);
		
		FriendVO friendVO1 = new FriendVO();
		friendVO1.setAge(1);
		friendVO1.setName("zyr1");
		FriendVO friendVO2 = new FriendVO();
		friendVO2.setAge(2);
		friendVO2.setName("zyr2");
		List<FriendVO> friendList = new ArrayList<FriendVO>();
		userVO.setFriendList(friendList);
		mav.addObject("friendList", friendList);
		
		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(@Valid UserVO userVO, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("add_success");
		mav.addObject("user", userVO);
		if (bindingResult.hasErrors()) {
			mav.addObject("error", bindingResult.getAllErrors());
			mav.setViewName("to_add");
		}

		return mav;
	}


	//文件上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile mFile) { //请求参数一定要与form中的参数名对应
		if (!mFile.isEmpty()) {
			// String path = this.servletContext.getRealPath("/tmp/"); //获取本地存储路径
			String path = request.getRealPath("/tmp/");
//			String path = "/tmp";
			 File dir = new File(path); 
			 if (!dir.exists()) {
				dir.mkdir();
			 }
			 
			try {
				 mFile.getFileItem().write(new File(dir, mFile.getName())); 
			} catch (Exception e) {
				//关闭流 //TODO
				e.printStackTrace();
			}
			
		}
		
		return "add_success";
	}
	
	
	@RequestMapping(value = "cookieTest", method = RequestMethod.GET)
	public ModelAndView cookie(@CookieValue("JSESSIONID") String cookieValue) { 
		ModelAndView mav = new ModelAndView("to_add");
		mav.addObject("JSESSIONID", cookieValue);
		
		return mav;
	}
	
	@ModelAttribute("modelAttributeForMethodKey")
	public String useModelAttribute() {
		return "modelAttributeForMethodValue";
	}
	
	@RequestMapping("useModelAttributeWithRequestMapping")
	@ModelAttribute("useModelAttributeWithRequestMappingKey")
	public String useModelAttributeWithRequestMapping() {
		return "useModelAttributeWithRequestMappingValue";
	}
	
	@RequestMapping("useModelAttributeOnParameter/{id}")
	public String useModelAttributeOnParameter(@ModelAttribute String id) {
		
		return "add_success";
	}
	
	//数据绑定测试
	@InitBinder
	public void initBind(DataBinder dataBinder) {
//	public void initBind(ExtendedServletRequestDataBinder dataBinder) {
//    public void initBind(WebRequestDataBinder dataBinder) { //使用WebRequestDataBinder 会报异常 //TODO
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
		// dataBinder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(new
		// SimpleDateFormat("yyyy-mm-dd"), true));
		// dataBinder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(new
		// SimpleDateFormat("yyyy-mm-dd"), false));
		// dataBinder.registerCustomEditor(Date.class, "birthday2", new CustomDateEditor(new
		// SimpleDateFormat("yyyy-mm-dd"), true));
		// dataBinder.registerCustomEditor(Date.class, "birthday2", new CustomDateEditor(new
		// SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@InitBinder("userVO")
	public void initBindForAdd(DataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
	}
}
