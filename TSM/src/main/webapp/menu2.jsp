<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*, cn.kgc.tangcco.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<base target=""
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/skin/css/base.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/skin/css/menu.css"
	type="text/css" />
<script language='javascript'>
	var curopenItem = '1';
</script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/skin/js/frame/menu.js"></script>
</head>
<body>
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'>
						<b>成绩管理</b>
					</dt>
					<dd style='display: block' class='sitem' id='items1_1'>
						<ul class='sitemu'>

							<li><a
								href='${pageContext.request.contextPath }/gradeservlet?method=querypage'
								target='main'>显示所有成绩</a></li>
							<li><a
								href='${pageContext.request.contextPath }/gradeservlet?method=querypage1'
								target='main'>显示所有已启用成绩</a></li>
							<li><a
								href='${pageContext.request.contextPath }/gradeservlet?method=querypage2'
								target='main'>显示所有未启用成绩</a></li>
							<li><a
								href='${pageContext.request.contextPath }/grade/addgrade.jsp'
								target='main'>录入成绩</a></li>
							<li><a
								href='${pageContext.request.contextPath }/grade/updategrade.jsp'
								target='main'>修改成绩</a></li>
							<li><a
								href='${pageContext.request.contextPath }/grade/deletegrade.jsp'
								target='main'>删除成绩</a></li>
						</ul>
					</dd>
				</dl>
			</td>
		</tr>
	</table>
</body>
</html>