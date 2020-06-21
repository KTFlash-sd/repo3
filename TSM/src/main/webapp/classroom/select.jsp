<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"></script>
</head>
<body>
<a href="student/student.jsp"><input type="button" value="返回"></a><br><br><br><br>
		<table id="t" width="60%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7" align="center" >
		<td height="24" colspan="12" background="${pageContext.request.contextPath }/skin/images/tbg.gif">&nbsp;学生信息&nbsp;</td>
		</tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学生编号：<input width="50" name="Sid" type="text" value="${student.sid }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学生姓名：<input width="50" name="Sname type="text" value="${student.sname }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>出生日期：<input width="50" name="Sbirth" type="date" value="${student.sbirth }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>性别：<input width="10 " name="Ssex" type="text" value="${student.ssex }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>邮箱：<input width="50" name="Sem" type="text" value="${student.sem }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>政治面貌：<input width="50" name="Sps" type="text" value="${student.sps }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>籍贯：<input width="50" name="Snative" type="text" value="${student.snative }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>专业id：<input width="50" name="Smajorid" type="text" value="${student.smajorid }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>家庭住址：<input width="50" name="Saddress" type="text" value="${student.saddress }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>联系电话：<input width="50" name="Stel" type="text" value="${student.stel }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学制：<input width="50" name="Sedu" type="text" value="${student.sedu }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系人：<input width="50" name="Sur" type="text" value="${ student.sur }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系电话：<input width="50" name="Surtel" type="text" value="${student.surtel}"  disabled></td></tr>
</table>
</body>
</html>