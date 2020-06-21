<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
<table id="t" width="60%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7" align="center" >
		<td height="24" colspan="12" background="${pageContext.request.contextPath }/skin/images/tbg.gif">&nbsp;学生信息&nbsp;</td>
		</tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学生编号：</td><td><input width="50" name="Sid" id="Sid" type="text" value="${student.sid }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学生姓名：</td><td><input width="50" name="Sname" id="Sname"  type="text" value="${student.sname }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>出生日期：</td><td><input width="50" name="Sbirth" id="Sbirth" type="date" value="${student.sbirth }"  ></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>性别：</td><td><input width="10 " name="Ssex" type="text" id="Ssex" value="${student.ssex }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>邮箱：</td><td><input width="50" name="Sem" type="email" id="Sem" value="${student.sem }"  ></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>政治面貌：</td><td><select name="Sps" id="Sps" required>
		<option value="群众">群众</option>
		<option value="党员">党员</option>
		<option value="团员">团员</option>
		</select></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>籍贯：</td><td><input width="50" name="Snative" type="text" id="Snative" value="${student.snative }"  ></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>专业：</td>
			<td><select id="se"></select></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>家庭住址：</td><td><input width="50" name="Saddress" type="text" id="Saddress" value="${student.saddress }"  ></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>联系电话：</td><td><input width="50" name="Stel" type="text" id="Stel" value="${student.stel }"  onkeyup="this.value=this.value.replace(/\D/g, '')"></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>学制：</td><td><input width="50" name="Sedu" type="text" id="Sedu" value="${student.sedu }"  disabled></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系人：</td><td><input width="50" name="Sur" type="text" id="Sur" value="${ student.sur }"  ></td></tr>
		<tr align="center"><td><br></td></tr>
		<tr align="center"><td>紧急联系电话：</td><td><input width="50" name="Surtel" type="text" id="Surtel"value="${student.surtel}"  onkeyup="this.value=this.value.replace(/\D/g, '')"></td></tr>
		<tr align="center"><td colspan="2"><input id="bt" type="button" value="提交"><a href="student/student.jsp"><input type="button" value="取消"></a><br></td></tr>
</table>
</form>
<script type="text/javascript">
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
	$("#bt").click(function(){
		var sid=$("#Sid").val();
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
			 data:{"method":"update" ,"Sid":sid,"Sname":sname,"Sbirth":sbirth,"Ssex":ssex,"Sem":sem,"Sps":sps,"Snative":snative,"Smajorid":smajorid,
				 "Saddress":saddress,"Stel":stel,"Sedu":sedu,"Sur":sur,"Surtel":surtel},
			 success:function(data){
				 var i=data;
				 if(i>0){
					 alert("修改成功");
					 window.self.location ="student/student.jsp";
				 }
				 else{
					 alert("修改失败");
				 }
			 }
		 });
	});
})

</script>
</body>
</html>