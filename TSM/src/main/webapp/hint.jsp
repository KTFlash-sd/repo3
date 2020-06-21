<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功</title>
</head>
<body>
<cencter>恭喜您注册成功,请点击<a href="mainlogin.jsp">登录</a><br>
		或5秒后自动跳转至登录界面！
		<%response.setHeader("refresh", "5;URL=mainlogin.jsp"); %>
</cencter>
</body>
</html>