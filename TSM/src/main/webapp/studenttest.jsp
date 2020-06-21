<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); 
   String contextpath=request.getContextPath();
   String url=path+contextpath+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=url%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="student" >
<input type="hidden" name="method" value="addStudent">
		<input name="Sname" type="text" value="张三">
		<input name="Sbirth" type="date" value="2019-11-11">
		<input name="Ssex" type="text" value="男">
		<input name="Sem" type="text" value="111@.com">
		<input name="Sps" type="text" value="主席">
		<input name="Snative" type="text" value="火星">
		<input name="Smajorid" type="text" value="id">
		<input name="Saddress" type="text" value="地球">
		<input name="Stel" type="text" value="123">
		<input name="Sedu" type="text" value="全日制">
		<input name="Surtel" type="text" value="111">
		<input name="Aid" type="text" value="1">
		<input name="Sur" type="text" value="祖宗">
		<input type="submit" value="提交">
</form>
</body>
</html>