<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	String contextpath = request.getContextPath();
	String url = path + contextpath + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=url%>">
<meta charset="UTF-8">
<title>显示所有未启用成绩</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"></script>
</head>

<body leftmargin="8" topmargin="8">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:成绩管理>>成绩列表</td>
						<td><a
							href="${pageContext.request.contextPath }/grade/addgrade.jsp">
								<input type='button' class="addbut" value='录入成绩' />
						</a>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!--  搜索表单  -->
	<form name='form3' action='' method='get'>
		<input type='hidden' name='dopost' value='' />
		<table width='98%' border='0' cellpadding='1' cellspacing='1'
			bgcolor='#CBD8AC' align="center" style="margin-top: 8px">
			<tr bgcolor='#EEF4EA'>
				<td background='skin/images/wbg.gif' align='center'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>搜索条件：</td>
							<td width='160'><select name='cid' style='width: 150'>
									<option value='0'>选择类型...</option>
									<option value='1'>学生id</option>
									<option value='1'>课程id</option>
							</select></td>
							<td width='70'>关键字：</td>
							<td width='160'><input type='text' name='keyword' value=''
								style='width: 120px' /></td>
							<td>&nbsp;&nbsp;&nbsp;<input name="imageField" type="image"
								src="${pageContext.request.contextPath }/skin/images/frame/search.gif"
								width="45" height="20" border="0" class="np" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<!--  内容列表   -->
	<form name="form2">

		<table id="t" width="98%" border="1" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7" align="center">
				<td height="24" colspan="12"
					background="${pageContext.request.contextPath }/skin/images/tbg.gif">&nbsp;成绩列表&nbsp;</td>
			</tr>
			<tr id="top1" align="center" bgcolor="#FAFAF1" height="22">
				<th width="12%">成绩编号</th>
				<th width="12%">课程名称</th>
				<th width="12%">学生名称</th>
				<th width="12%">分数</th>
				<th width="12%">成绩时间</th>
				<th width="12%">状态</th>
				<th width="12%">是否删除</th>
				<th width="14%">操作</th>
			</tr>


			<c:forEach items="${grade}" var="grades">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td>${grades.gid }</td>
					<td>${grades.lname }</td>
					<td>${grades.sname }</td>
					<td>${grades.gscore }</td>
					<td>${grades.gtime }</td>
					<td>${grades.gstate==0?"已废弃":(grades.gstate==1?"未启用":"已启用") }</td>
					<td>${grades.gdel }</td>
					<td><a
						href="${pageContext.request.contextPath }/gradeservlet?method=delete&Gid=${grades.gid }&thispage=${pagebean.thispage }">删除</a>
						| <a
						href="${pageContext.request.contextPath }/gradeservlet?method=update&Gid=${grades.gid }">编辑</a>
					</td>
				</tr>
			</c:forEach>


			<tr align="center">
				<td colspan="2">&nbsp; <a href="" class="coolbg">全选</a> <a
					href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="" class="coolbg">&nbsp;注销&nbsp;</a> <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
				</td>
				<td colspan="2">总共${pagebean.totalpage }页|当前${pagebean.thispage }页
				</td>
				<td colspan="2">总共${pagebean.totalsize }条|当前${pagebean.pagesize }条
				</td>
				<td colspan="2"><a
					href="${pageContext.request.contextPath }/gradeservlet?method=querypage2&thispage=1">【首页】</a>
					<a
					href="${pageContext.request.contextPath }/gradeservlet?method=querypage2&thispage=${pagebean.thispage-1}">【上一页】</a>
					<a
					href="${pageContext.request.contextPath }/gradeservlet?method=querypage2&thispage=${pagebean.thispage+1}">【下一页】</a>
					<a
					href="${pageContext.request.contextPath }/gradeservlet?method=querypage2&thispage=${pagebean.totalpage }">【末页】</a></td>
			</tr>
		</table>
	</form>
</body>
</html>