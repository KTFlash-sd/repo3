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
<title>添加新角色</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<body>
   
<center style="margin:150px">
<h1 style="margin:20px">请输入角色信息</h1>
   <form action="${pageContext.request.contextPath }/role.do" method="post">
      <input type="hidden" name="method" value="add">
      <table align="center" cellpadding="0" cellspacing="0" border="1"
			width="600px">
      <tr align="center">
      <td height="30" align="center">角色名称:</td>
      <td><input type="text" name="Rname" style="margin:20px"></td>
      </tr>
       <tr>
				<td height="30" align="center">操作</td>
				<td height="30" align="center"><input type="submit"
					value="添加"> &nbsp;&nbsp; <input type="reset" value="重置" /></td>
		</tr>
		</table>
   </form>
   </center>
</body>
</html>