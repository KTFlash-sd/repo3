<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>项目管理系统</title>

</head>
   ${message}！<br>
   5秒后自动返回到登录，或者点击<a href="mainlogin.jsp" target="_top">返回登录页面</a>
     <%response.setHeader("refresh", "5;URL=mainlogin.jsp"); %>
</html>