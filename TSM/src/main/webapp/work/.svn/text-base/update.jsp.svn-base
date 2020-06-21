<%@page import="cn.kgc.tangcco.zhangyu.work.entity.WorkBean"%>
<%@page import="cn.kgc.tangcco.entity.Teacher"%>
<%@page import="cn.kgc.tangcco.entity.Lesson"%>
<%@page import="java.util.List"%>
<%@page import="cn.kgc.tangcco.entity.Work"%>
<%@page import="cn.kgc.tangcco.entity.Student"%>
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
<a href="work/work.jsp"><input type="button" value="返回"></a><br><br><br><br>
<input type="hidden" name="wid" value="${work.wid }">
		<table id="t" width="60%" border="0" cellpadding="2" cellspacing="1"  align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7" align="center" >
		<td height="24" colspan="2" >&nbsp;课程编辑&nbsp;</td>
		</tr><tr height="30px"></tr>
		
		<tr  align="center" ><td>班级：</td>
		<td>
		<select name="cid" disabled="disabled">
		<option value="${classroom}" selected>${work.cname }</option>
		</select>
		</td>
		</tr>
		<tr height="20px"></tr>
		<tr align="center" >
		<td>专业：</td><td>
		<select name="lid">
		<option value="${lesson }" selected>${work.lname }</option>
		<c:forEach items="${llist }" var="les">
		<option value="${les.lid }" >${les.lname }</option>
		</c:forEach></select></td>
		</tr><tr height="20px"></tr>
		<tr align="center" >
		<td>教师：</td><td>
		<select name="tid" required>
		<c:forEach items="${tlist }" var="tea">
		<option value="${tea.tid }" >${tea.tname }</option>
		</c:forEach></select></td>
		</tr><tr height="20px"></tr>
		<tr align="center" >
		<td>日期：</td><td>
		<input type="date" name="Wstart"  ></td></tr>
		<tr height="20px"></tr>
		<tr align="center" ><td>上课时间：</td><td><select  name="start" required   >
		<option id="s1" value=" 08:30">08:30</option>
		<option id="s2" value=" 09:30">09:30</option>
		<option id="s3" value=" 10:30">10:30</option>
		<option id="s4" value=" 11:30">11:30</option>
		<option id="s5" value=" 13:30">13:30</option>
		<option id="s6" value=" 14:30">14:30</option>
		<option id="s7" value=" 15:30">15:30</option>
		<option id="s8" value=" 16:30">16:30</option>
		</select></td></tr><tr height="20px"></tr>
		<tr align="center" ><td>
		下课时间：</td><td><select   id="end" name="end" required >
		<option id="e1" value=" 09:20">09:20</option>
		<option id="e2" value=" 10:20">10:20</option>
		<option id="e3" value=" 11:20">11:20</option>
		<option id="e4" value=" 13:20">13:20</option>
		<option id="e5" value=" 14:20">14:20</option>
		<option id="e6" value=" 15:20">15:20</option>
		<option id="e7" value=" 16:20">16:20</option>
		<option id="e8" value=" 17:20">17:20</option>
		</select>
		</td></tr><tr height="20px"></tr>
		<tr align="center" >
		<td>周期：</td><td>
		<input type="number" name="wtime" value="${work.wtime }">（周）
		</td></tr><tr height="20px"></tr>
		<tr align="center" ><td colspan="2" >
		<input type="button" name="but" value="提交">&nbsp<a href="work.jsp"><input type="button" value="返回"></a>
		</td></tr>
</table>
</body>
<script type="text/javascript">
$(function(){
	$("[name=start]").change(function(){
		$("#end option").show();
		$("#end option").removeAttr('selected');
		var index=$(this).children('option:selected').index()
		
		$("#end option").eq(index).attr("selected", "selected");
		$("#end option").eq(index).siblings().hide();
		
	})
	
	
	$("[name=but]").click(function(){
		var wid=$("[name=wid]").val();
		var cid=$("[name=cid]").val();
		var lid=$("[name=lid]").val();
		var tid=$("[name=tid]").val();
		var start=$("[name=Wstart]").val();
		var time=$("[name=wtime]").val();
		var wend=$("[name=end]").val();
		var wstart=$("[name=start]").val();
		$.ajax({
			 url:"work",
			 data:{"method":"update" ,"Wid":wid,"Cid":cid,"Lid":lid,"Tid":tid,"Wstart":start+wstart,"Wend":start+wend,"Wtime":time},
			 success:function(data){
				 var i=data;
				 if(i>0){
					 alert("修改成功");
					 window.self.location ="work/work.jsp";
				 }
				 else{
					 alert("修改失败");
				 }
			 }
		 });
	})
})
</script>
</html>