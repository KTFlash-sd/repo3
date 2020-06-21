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
<title>录入成绩</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<body>
	<!--  <script>
		$(function() {
			$("#rid option").remove();
			$.ajax({
				url : "${pageContext.request.contextPath }/account.do",
				data : {
					"method" : "queryrole"
				},
				success : function(data) {
					$.each(data, function(index, role) {
						$("#rid").append(
								"<option value="+role.rid+">" + role.rname
										+ "</option>");
					});
				},
				dataType : "json"
			});
		});
	</script>-->
	<center style="margin: 150px">
		<h1>请输入成绩信息</h1>
		<p>
		<form action="${pageContext.request.contextPath }/gradeservlet" method="post">
			<input type="hidden" name="method" value="add"> 
			课程编号<input type="number" name="Lid" style="margin: 20px"><br>
			学生编号<input type="number" name="Sid" style="margin: 20px"><br>
			分数<input type="number" name="Gscore" style="margin: 20px"><br>
			成绩时间<input type="date" name="Gtime" style="margin: 20px"><br>
			<input type="hidden" name="Gstate" value="${grades.gstate }"> 
			<input type="hidden" name="Gdel" value="${grades.gdel }">
			<p>
				<input type="submit" value="添加"> 
				<input type="reset" value="重置">
			</p>
		</form>
		</p>
	</center>
</body>
</html>