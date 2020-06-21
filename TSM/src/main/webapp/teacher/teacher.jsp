<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>显示所有教师</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/css/base.css">
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js" type="text/javascript"></script>
</head>
<body>
   <body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath }/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCDDFF" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath }/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td>当前位置:权限管理>>教师列表</td>
  <td>
    <a
							href="${pageContext.request.contextPath}/teacher/addTeacher.jsp">
								<input type='button' class="coolbg np" value='添加教师' />
						</a>
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
							<td width='70'>模糊查询：</td>
							<td width='160'><input type='text' name='like' value=''
								style='width: 120px' placeholder="姓名" /></td>
							<td width='110'>&nbsp;&nbsp;&nbsp;<input id="sousuo"
								type="button" value="搜索" />
							</td>

						</tr>
     
      </table>
    </td>
 </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2"  action="account.do">

<table id="t" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="white" align="center" style="margin-top:8px">
<tbody>

<tr align="center" bgcolor="#FAFAF1" height="22"  class="one">
				<th>姓名</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>出生日期</th>
				<th>政治面貌</th>
				<th>籍贯</th>
				<th>联系方式</th>
				<th>专业</th>
				<th>教龄</th>
				<th>职称</th>
				<th>操作</th>
</tr>

<c:forEach items="${alist }" var="account">



</c:forEach>
</tbody>


</table>
</form>
<div align="right">
		<!-- 分页 -->
		第<span id="p"></span>页 <span id="s"></span> <span id="head"><input
			type="button" value="首页"> </span> 
			<span id="up"><input type="button" value="上一页"> </span> 
			<span><input id="down" type="button" value="下一页"> </span>
			 <span id="body"><input type="button" value="尾页"> </span>
	</div>
	<input type="hidden" id="totalpage">

	</div> 
<script type="text/javascript">
		$(function() {
			/* 全局变量 */
			ajaxmethod(1);
			$("#head").click(function() {
				ajaxmethod(1);
			});
			$("#up").click(function() {
				var val = parseInt(new $("#p").html());
				ajaxmethod(val - 1);
			});

			$("#down").click(function() {
				var val = parseInt(new $("#p").html());

				ajaxmethod(val + 1);
			});
			$("#body").click(function() {
				
				ajaxmethod($("#totalpage").val());
			});
		});

		function ajaxmethod(value) {
			$("#t tr:not(.one)").remove(); //首先移除表格中除第一行之外的其他行 
			$
					.ajax({
						url : "${pageContext.request.contextPath}/teacher",//跳转地址路径
						data : "method=queryPageTeacher&thispage=" + value,//给method和thispage赋值
						success : function(data) {
							var pagebean = data.pagebean;
							var rows = data.rows;
							$
									.each(
											rows,
											function(index, teacher) {
												$("#t").append("<tr align='center'   ><td>"+ teacher.tname
																		+ "</td><td>"
																		+ teacher.tsex
																		+ "</td><td>"
																		+ teacher.tem
																		+ "</td><td>"
																		+ teacher.tbirths
																		+ "</td><td>"
																		+ teacher.tps
																		+ "</td><td>"
																		+ teacher.tnative
																		+ "</td><td>"
																		+ teacher.ttel
																		+ "</td><td>"
																		+ teacher.tmajor
																		+ "</td><td>"
																		+ teacher.tyear
																		+ "</td><td>"
																		+ teacher.tiob
																		+ "</td><td><a href='${pageContext.request.contextPath}/teacher?method=idquery&Tid="+ teacher.tid+ "'>编辑||</a>"
																		+ "<a href='javascript:void(0);' id='del' onclick='del("
																		+ teacher.tid
																		+ ")'>删除</a></td></tr>");
											});
							$("#s").html("共" + pagebean.totalpage + "页   共"+ pagebean.totalsize + "条/每页"+ pagebean.pagesize + "条");
							$("#p").html(pagebean.thispage);
							$("#totalpage").val(pagebean.totalpage);
						},
						dataType : "json"
					});
		}
		
		function del(tid) {
			$.ajax({
				url : "${pageContext.request.contextPath}/teacher",
				data : "method=delectTeacher&Tid=" + tid,
				success : function(data) {
					if (data > 0) {
						alert("删除成功");
						ajaxmethod($("#p").html());
					} else {
						alert("删除失败");
					}
				}
			});

		}

		$("#sousuo")
				.click(
						function() {
							$("#t tr:not(.one)").remove();
							var Tname = $("[name=like]").val();
							$
									.ajax({
										url : "${pageContext.request.contextPath}/teacher",//跳转地址路径
										data : "method=nameTeacher&Tname="
												+ Tname,//给method和thispage赋值
										success : function(data) {
											var pagebean = data.pagebean;
											var rows = data.rows;
											$
													.each(
															rows,
															function(index,
																	teacher) {
																$("#t")
																		.append(
																				"<tr><td>"
																						+ teacher.tname
																						+ "</td><td>"
																						+ teacher.tsex
																						+ "</td><td>"
																						+ teacher.tem
																						+ "</td><td>"
																						+ teacher.tbirths
																						+ "</td><td>"
																						+ teacher.tps
																						+ "</td><td>"
																						+ teacher.tnative
																						+ "</td><td>"
																						+ teacher.ttel
																						+ "</td><td>"
																						+ teacher.tmajor
																						+ "</td><td>"
																						+ teacher.tyear
																						+ "</td><td>"
																						+ teacher.tiob
																						+ "</td><td><span id='del' onclick='del("
																						+ teacher.tname
																						+ ")'>删除</span></td></tr>");
																console
																		.log(teacher.Tname);
															});
											$("#s")
													.html(
															"共"
																	+ pagebean.totalpage
																	+ "页   共"
																	+ pagebean.totalsize
																	+ "条/每页"
																	+ pagebean.pagesize
																	+ "条");
											$("#p").html(pagebean.thispage);
										},
										dataType : "json"
									});
						});
	</script>

</body>
</html>