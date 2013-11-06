<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<%-- 	<f:form action="add" method="post" commandName="userVO"> --%>
<!-- 或者使用 modelAttribute -->
	<f:form action="add" method="post" modelAttribute="userVO" >
<%-- 	<f:form action="add" method="post"  > --%>
		姓名: <f:input title="姓名"  path="name"/>
		年龄：<f:input path="age"/>
		出生日期：<f:input path="birthday"/>
		地址：<f:input path="addressVO.value"/>
		
		<p/>
<!-- checkbox 测试 -->
<%-- 性别：<f:radiobuttons path="married" element=""/> --%>
		<f:checkbox path="married" label="已婚"/>
		<p/>
		
<!--   测试绑定一个Object数据  -->
		<f:checkbox path="name" value="zyr" label="测试绑定一个Object数据"/>
		<p/>
		
<!-- TODO 使用常量？ -->
		爱好：
			<f:checkbox path="like" value="sport" label="运动" />
			<f:checkbox path="like" value="sing" label="唱歌" />
			<f:checkbox path="like" value="dance" label="跳舞" />


<!-- checkboxes 测试 -->
		<p/>
		<!-- TODO 用常量代替，展示"运动" -->
		爱好2：
		<f:checkboxes items="${userVO.like }" path="like" /> 

		<p/>
		爱好3：
		<%-- 
		<f:checkboxes items="${ likeMap}" path="like" />
		--%>
<%-- 		<f:checkboxes items="${ likeMap}" path="like" itemLabel="" itemValue=""/> --%>

		<p/>
		
		朋友：
		<f:checkboxes items="${friendList }" path="friendList" itemLabel="name" itemValue="age"/>
		<p/>
		
		
		
		<input type="submit" value="保存" />
	</f:form>
	
	
	
	
<!-- 	<form action="add" method="post"> -->
<%-- 	${error } --%>
<%-- 	姓名：<input name="name" value = "${userVO.name}"> --%>
<%-- 	年龄：<input name="age" value = "${userVO.age}"> --%>
<%-- 	出生日期：<input name="birthday" value = "${userVO.birthday}"> --%>
<%-- 	estVO.name :<input name="testVO.name" value="${testVO.name}"/> --%>
<!-- 		<input type="submit" value="保存"/> -->
<!-- 	</form> -->

<!-- 	<form action="upload" method="post" enctype="multipart/form-data"> -->
<!-- 		选择文件： -->
<!-- 		<input type="file" name="file" /> -->
<!-- 		<input type="submit" value="上传"/> -->
<!-- 	</form> -->
</body>
</html>