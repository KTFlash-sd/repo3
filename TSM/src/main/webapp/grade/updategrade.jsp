<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #CCEEFF;
}
</style>
<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>修改成绩</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<body>
	<!--
	<script>
         $(function(){
        	 $("#rid option").remove();
        	 $.ajax({
        		 url:"${pageContext.request.contextPath }/account.do",
        		 data:{"method":"queryrole"},
        		 success:function(data){
        			 $.each(data,function(index,role){
        				 $("#rid").append("<option value="+role.rid+" "+(role.rid==${account.rid}?"selected":"")+">"+role.rname+"</option>");
        			 });       
        		 }
        		 dataType:"json"
        	 });
         });
    </script>
	-->
	<%
		String gid = request.getParameter("Gid");
		String lid = request.getParameter("Lid");
		String sid = request.getParameter("Sid");
		String sname = request.getParameter("Sname");
		String lname = request.getParameter("Lname");
	%>
	<center margin="150px">
		<h1>请修改成绩信息</h1>
		<form action="${pageContext.request.contextPath }/gradeservlet">
			<input type="hidden" name="method" value="update"> 
			<input type="hidden" name="Gid" value="<%=gid %>"> 
			<input type="hidden" name="Lid" value="<%=lid %>"> 
			<input type="hidden" name="Sid" value="<%=sid %>"> 
			课程名称<input type="text" name="Lid" disabled="value" value="<%=lname %>" style="margin: 20px"><br>
			学生姓名<input type="text" name="Sid" disabled="value" value="<%=sname %>" style="margin: 20px"><br>
			分数<input type="number" name="Gscore" style="margin: 20px"><br>
			成绩时间<input type="date" name="Gtime" style="margin: 20px"><br>
			<input type="hidden" name="Gstate" value="${grades.gstate }"> 
			<input type="hidden" name="Gdel" value="${grades.gdel }">
			<p>
				<input type="submit" value="修改"> 
				<input type="reset" value="重置">
			</p>
		</form>
	</center>
</body>
</html>