<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
		div{
				background:url(images/logo1.png);
				background-size:660px 75px;
				background-repeat:no-repeat;
				background-position:center;
			}
		</style>
	</head>
	<body>
		<div id="top" style="position:absolute ; top: 0;left: 0;right: 0;height:50px; background-color:#CBD8AC; vertical-align:middle;  text-align:center;">
				<p align="right"  style="color: brown;">
               欢迎，${sessionScope.account.username}登录，<a href="index.jsp?exit=true"  target="_top" onclick="return confirm('确认注销吗？')">点击注销</a>
    			</p>
		</div>
	</body>
</html>