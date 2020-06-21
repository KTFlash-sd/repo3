<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cn.kgc.tangcco.entity.Grade"%>
<%@page import="java.util.List"%>
<%@page import="cn.kgc.tangcco.util.Utils"%>
<%@page import="cn.kgc.tangcco.util.PageBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="grade/addgrade.jsp">添加成绩</a>
	<a href="grade/updategrade.jsp">修改成绩</a>
	<a href="grade/deletegrade.jsp">删除成绩</a>
	<table border="1" width="90%" height="300px" align="center">
		<tr>
			<th>成绩编号</th>
			<th>课程编号</th>
			<th>学生编号</th>
			<th>分数</th>
			<th>成绩时间</th>
			<th>状态</th>
			<th>是否删除</th>
			<th>操作</th>
		</tr>
		<%
			List<Grade> grades = (List<Grade>) request.getAttribute("grade");
			for (Grade grade : grades) {
		%>
		<tr align="center">
			<td><%=grade.getGid()%></td>
			<td><%=grade.getLid()%></td>
			<td><%=grade.getSid()%></td>
			<td><%=grade.getGscore()%></td>
			<td><%=grade.getGtime()%></td>
			<td><%=grade.getGstate()%></td>
			<td><%=grade.getGdel()%></td>
			<td><a href="delete?Gid=<%=grade.getGid()%>"
				onclick="return confirm('确认删除么？')">删除</a> <a
				href="update?Gid=<%=grade.getGid()%>"
				onclick="return confirm('确认修改么？')">修改</a></td>

		</tr>
		<%
			}
		%>
		<%
			PageBean pagebean = (PageBean) request.getAttribute("pagebean");
		%>
		<tr align="center">
			<td colspan="2">总共${pagebean.totalpage }页|当前${pagebean.thispage }页
			</td>
			<td colspan="2">总共${pagebean.totalsize }条|当前${pagebean.pagesize }条
			</td>
			<td colspan="4"><a
				href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=1">【首页】</a>
				<a
				href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.thispage-1}">【上一页】</a>
				<a
				href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.thispage+1}">【下一页】</a>
				<a
				href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.totalpage }">【末页】</a></td>
		</tr>
	</table>

</body>
</html>