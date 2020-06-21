<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 ${message}！<br>
   5秒后自动返回到角色页面，或者点击<a href="${pageContext.request.contextPath }/role.do?method=query&thispage=1" >返回角色主页面</a>
     <%response.setHeader("refresh", "5;URL=role.do?method=query&thispage=1"); %>
</body>
</html>