<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="add" method="post">
	姓名：<input name="name" value = "${userVO.name}">
<%-- 	姓名：<input name="userVO.name" value = "${userVO.name}"> --%>
	年龄：<input name="age" value = "${userVO.age}">
	出生日期：<input name="birthday" value = "${userVO.birthday}">
	estVO.name :<input name="testVO.name" value="${testVO.name}"/>
		<input type="submit" value="保存"/>
	</form>

</body>
</html>