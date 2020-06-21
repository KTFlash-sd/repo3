<%@page import="cn.kgc.tangcco.entity.Major"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
    <% String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); 
   String contextpath=request.getContextPath();
   String url=path+contextpath+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=url%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.js"></script>
</head>
<body>
<a href="student/student.jsp"><input type="button" value="返回"></a><br><br><br><br>
<table id="t" id="one" width="40%" border="0" cellpadding="2" cellspacing="1"  align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7"  class="kk" align="center">
		<td height="24" colspan="2" >&nbsp;学员信息&nbsp;</td>
		</tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学生姓名：</td><td><input width="30" name="Sname"  type="text"  id="Sname""Sname" required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>出生日期：</td><td><input width="30" name="Sbirth"  type="date"  id="Sbirth" required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>性别：</td><td><input width="10 " name="Ssex"  id="Ssex" type="radio" checked="true"  value="男">男 <input width="10 " name="Ssex" type="radio"  value="女">女</td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>邮箱：</td><td><input width="30" name="Sem"  id="Sem" type="email" required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>政治面貌：</td><td><select name="Sps" id="Sps" required>
		<option value="群众">群众</option>
		<option value="党员">党员</option>
		<option value="团员">团员</option>
		</select></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>籍贯：</td><td><input width="30" name="Snative"id="Snative"  type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>专业：</td><td><select id="se">
		</select></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>家庭住址：</td><td><input width="30" name="Saddress" id="Saddress" type="text"   required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>联系电话：</td><td><input width="30" name="Stel" id="Stel" type="text"  required  onblur="check(this)"></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学制：</td><td><select name="Sedu" id="Sedu" required>
		<option value="全日制">全日制</option>
		<option value="非全日制">非全日制</option>
		<option value="研修班">研修班</option>
		</select></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系人：</td><td><input width="30" name="Sur" id="Sur" type="text"  required></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系电话：</td><td><input width="30" name="Surtel" id= "Surtel"type="text"  required onblur="check(this)"></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center" ><td colspan="2">
		<input type="button" id="b" value="提交">
		<a href="student/student.jsp"><input type="button" value="取消"></a>
		<br></td></tr>
</table>
<script type="text/javascript">

function check(temp){
	 var re = /^1\d{10}$/
	 if(!re.test(temp.value)){
	  alert("手机号码格式不正确，请重新输入!");
	  return;
	 }
	}
$(function(){
	$.ajax({
		 url:"student",
		 data:{"method":"major" },
		 success:function(data){
			 var rows=data
			 $.each(rows,function(index,major){
				 $("#se").append("<option value="+major.mAid+">"+major.mAname+"</option>");
				});
		 },
		 dataType:"json"
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

</script>
</body>
</html>