<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/delete">
		<table align="center" cellpadding="0" cellspacing="0" border="1"
			width="600px">
			<tr align="center">
				<td height="30" align="center">课程编号</td>
				<td><input type="number" name="Lid"></td>
			</tr>
			<tr align="center">
				<td height="30" align="center">学生编号</td>
				<td><input type="number" name="Sid"></td>
			</tr>
			<tr>
				<td height="30" colspan="2" align="center"><input type="submit"
					value="删除"> &nbsp;&nbsp; <input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>