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
<title>添加新教师</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<body>
    <script type="text/javascript">
function check(temp){
	var re = /^1\d{10}$/
	if(!re.test(temp.value)){
		alert("手机号码格式不正确，请重新输入!");
		return;
	}
}


$(function(){
	$("#b").click(function(){
		var Tname=$("#Tname").val();
		var Tbirth=$("#Tbirth").val();
		var Tsex=$("[name=Tsex]").val();
		var Tem=$("#Tem").val();
		var Tps=$("#Tps").val();
		var Tnative=$("#Tnative").val();
		var Ttel=$("#Ttel").val();
		var Tmajor=$("#Tmajor").val();
		var Tyear=$("#Tyear").val();
		var Tiob=$("#Tiob").val();
		$.ajax({
			 url:"${pageContext.request.contextPath}/teacher",
			 data:{"method":"addTeacher" ,"Tname":Tname,"Tsex":Tsex,"Tem":Tem,"Tbirth":Tbirth,"Tps":Tps,"Tnative":Tnative,"Ttel":Ttel,"Tmajor":Tmajor,
				 "Tyear":Tyear,"Tiob":Tiob},
			 success:function(data){
				 var i=data;
				 if(i>0){
					 alert("添加成功");
					 window.self.location ="${pageContext.request.contextPath }/teacher/teacher.jsp";
				 }
				 else{
					 alert("添加失败");
				 }
			 }
		 });
	});
})

</script>
<center style="margin:90px">
	<h1>请输入教师信息</h1>
<table id="t" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCEEFF" align="center" style="margin-top:20px">
		<tr align="center"></tr>
		<tr align="center"><td>教师姓名：<input width="50" id="Tname" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>性别：<input width="10 " name="Tsex" type="radio" value="男" checked >男 <input width="10 " name="Tsex" type="radio" value="女"  >女</td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>邮箱：<input width="50" id="Tem" type="text" onblur="check_mail(document.getElementsByName('u_mail')[0].value)" required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>出生日期：<input width="50" id="Tbirth" type="date"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>政治面貌：<input width="50" id="Tps" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>籍贯：<input width="50" id="Tnative" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>联系电话：<input width="50" id="Ttel" type="text" name="telephone" onblur="check(this)" required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>专业：<input width="50" id="Tmajor" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>教龄：<input width="50" id="Tyear" type="text"  required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>职称：<input width="50" id="Tiob" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>
		<input type="button" id="b" value="提交">
		<a href="${pageContext.request.contextPath}/teacher/teacher.jsp"><input type="button" value="取消"></a>
		<br></td></tr>
</table>
   </center>
</body>
</html>