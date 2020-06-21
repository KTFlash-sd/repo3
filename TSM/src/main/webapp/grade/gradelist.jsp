<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>显示所有成绩</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/skin/css/base.css">
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"
	type="text/javascript"></script>
</head>
<body leftmargin="8" topmargin="8"
	background='${pageContext.request.contextPath }/skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#CCDDFF" align="center">
		<tr>
			<td height="26"
				background="${pageContext.request.contextPath }/skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:成绩管理>>成绩列表</td>
						<td><input type='button' class="coolbg np"
							onClick="location='${pageContext.request.contextPath }/grade/addgrade.jsp';"
							value='录入成绩' /></td>
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
							<td width='70'>关键字：</td>
							<td width='160'><input type="text" id="filterName">
							</td>
						
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>


	<!--  内容列表   -->
	<form name="form2">

		<table id="one" width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tbody>
				<tr bgcolor="#E7E7E7" class="kk">
					<td height="24" colspan="12"
						background="${pageContext.request.contextPath }/skin/images/tbg.gif">&nbsp;成绩列表&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22" class="kk">
					<td width="10%">选择</td>
					<th width="10%">成绩编号</th>
					<th width="10%">课程名称</th>
					<th width="10%">学生名称</th>
					<th width="10%">分数</th>
					<th width="14%">成绩时间</th>
					<th width="10%">状态</th>
					
					<th width="14%">操作</th>
				</tr>

				<c:forEach items="${grade}" var="grades">

					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td><input name="aid" type="checkbox" id="id"
							value="${grades.gid }" class="np"></td>

						<td>${grades.gid }</td>
						<td>${grades.lname }</td>
						<td>${grades.sname }</td>
						<td>${grades.gscore }</td>
						<td>${grades.gtime}</td>
						<td>${grades.gstate==0?"未启用":(grades.gstate==1?"已启用":"已废弃") }</td>
						
						<td><a
							href="${pageContext.request.contextPath }/gradeservlet?method=delete&Gid=${grades.gid }&thispage=${pagebean.thispage }"
							onclick="return confirm('确认删除吗？')">删除</a> | <a
							href="${pageContext.request.contextPath }/gradeservlet?method=select&Gid=${grades.gid }&Lid=${grades.lid }&Sid=${grades.sid}&Sname=${grades.sname}&Lname=${grades.lname}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

			<tr bgcolor="#FAFAF1" class="kk">
				<td height="28" colspan="12">&nbsp; <input type="button"
					name="checkall" id="checkall" value="全选" onclick="one()">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" name="checkNo" id="checkNo" value="全不选"
					onclick="noall()">&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="button" name="checkReverse" id="checkReverse" value="反选"
					onclick="isall()"></a>&nbsp;&nbsp;&nbsp;&nbsp; <!--  <input type="">&nbsp;注销&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>-->
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA" class="kk">
				<td height="36" colspan="8" align="center">
					共${pagebean.totalsize }条/每页${pagebean.pagesize }条
					共${pagebean.totalpage }页/第${pagebean.thispage }页 
					<a href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=1">[首页]</a>
					<a href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.thispage-1}">[上一页]</a>
					<a href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.thispage+1}">[下一页]</a>
					<a href="${pageContext.request.contextPath }/gradeservlet?method=querypage&thispage=${pagebean.totalpage }">[末页]</a>
				</td>
			</tr>
		</table>
	</form>
	<script>
		$(function() {
			//设置列表查询
			$("#filterName").blur(function() {
				$("#one tbody tr").not($(".kk")).stop().hide() //将tbody中的tr都隐藏
				.filter(":contains('" + ($(this).val()) + "')").show(); //，将符合条件的筛选出来
			});
			$("#b").click(function(){
				var sname=$("#Sname").val();
				var sbirth=$("#Sbirth").val();
				var ssex=$("#Ssex").val();
				var sem=$("#Sem").val();
				var sps=$("#Sps").val();
				var snative=$("#Snative").val();
				var smajorid=$("#se").val();
				var saddress=$("#Saddress").val();
				var stel=$("#Stel").val();
				var sedu=$("#Sedu").val();
				var sur=$("#Sur").val();
				var surtel=$("#Surtel").val();
				$.ajax({
					 url:"student",
					 data:{"method":"add" ,"Sname":sname,"Sbirth":sbirth,"Ssex":ssex,"Sem":sem,"Sps":sps,"Snative":snative,"Smajorid":smajorid,
						 "Saddress":saddress,"Stel":stel,"Sedu":sedu,"Sur":sur,"Surtel":surtel},
					 success:function(data){
						 var i=data;
						 if(i>0){
							 alert("添加成功");
							 window.self.location ="student/student.jsp";
						 }
						 else{
							 alert("添加失败");
						 }
					 }
				 });
			});
		})
		
		
		// 处理全选

		function one() {
			/*************************************************/
			// 获取所有的复选框
			var checkElements = document.getElementsByName('aid');
			for (var i = 0; i < checkElements.length; i++) {
				var checkElement = checkElements[i];
				// 方法一
				// checkElement.setAttribute('checked',' checked');
				// 方法二
				checkElement.checked = true;
			}
		}

		/*************************************************/
		// 处理全不选
		function noall() {
			// 获取所有的复选框
			var checkElements = document.getElementsByName('aid');
			for (var i = 0; i < checkElements.length; i++) {
				var checkElement = checkElements[i];
				// 方法一火狐不支持
				// checkElement.setAttribute('checked',null);
				// 方法二 火狐和ie都支持
				checkElement.checked = false;
			}
		}
		/******************************************************************/
		//反选
		function isall() {
			// 获取所有的复选框
			var checkElements = document.getElementsByName('aid');
			for (var i = 0; i < checkElements.length; i++) {
				var checkElement = checkElements[i];
				if (checkElement.checked) {
					checkElement.checked = false;
				} else {
					checkElement.checked = true;
				}
				// 方法一
				// checkElement.setAttribute('checked',null);
				// 方法二 火狐和ie都支持

			}
		}
		/***********************************************************/
		/* 	//全选/不选
			document.getElementById('checkItems').οnclick=function()
			{
			 // 获取所有的复选框
				var checkElements=document.getElementsByName('items');
				if (this.checked) {
					for(var i=0;i<checkElements.length;i++){
						var checkElement=checkElements[i];
						checkElement.checked="checked";
					}
		
				}
				else{
					for(var i=0;i<checkElements.length;i++){
						var checkElement=checkElements[i];
						checkElement.checked=null;
					}
				}
		
			} */
			
	</script>

</body>
</html>