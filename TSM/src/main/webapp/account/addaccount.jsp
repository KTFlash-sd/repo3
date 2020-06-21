<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body
  {
  background-color:#CCEEFF;
  }
</style>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>添加新用户</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<body>
    <script>
         $(function(){
        	 $("#rid option").remove();
        	 $.ajax({
        		 url:"${pageContext.request.contextPath }/account.do",
        		 data:{"method":"queryrole"},
        		 success:function(data){
        			 $.each(data,function(index,role){
        				 $("#rid").append("<option value="+role.rid+">"+role.rname+"</option>");
        			 });        			 
        		 },
        		 dataType:"json"
        	 });
         });
    </script>
<center style="margin:150px">
	<h1 style="margin:20px">请输入用户信息</h1>
	<form action="${pageContext.request.contextPath }/account.do" method="post">
		<input type="hidden" name="method" value="add">
		<table align="center" cellpadding="0" cellspacing="0" border="1"
			width="600px"> 
			<tr align="center">
				<td height="30" align="center">用户名:</td>
				<td><input type="text" name="username" style="margin:20px"></td>
			</tr>
			<tr align="center">
				<td height="30" align="center">密码:</td>
				<td><input type="password" name="psd" style="margin:20px"></td>
			</tr>
			<tr align="center">
				<td height="30" align="center">所属角色</td>
				<td><input type="radio" name="Rid" value="2">学生
              				<input type="radio" name="Rid" value="3">教师</td>
			</tr>
			<tr align="center">
				<td height="30" align="center">操作</td>
				<td height="30" align="center"><input type="submit"
					value="添加"> &nbsp;&nbsp; <input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
   </center>
</body>
</html>