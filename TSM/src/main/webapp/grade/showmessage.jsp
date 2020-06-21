<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("message")%>
	<br>5秒后自动返回到查询页面，或者点击
	<a
		href='${pageContext.request.contextPath }/gradeservlet?method=querypage'>显示所有成绩</a>

	<%
		response.setHeader("refresh", "5;URL=gradeservlet?method=querypage&thispage=1");
	%>
</body>
</html>