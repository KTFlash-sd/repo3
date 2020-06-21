<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body
  {
  background-color:#CCDDFF;
  }
</style>
<meta charset="UTF-8">
<title>修改菜单</title>
</head>
<body><center margin="150px">
	<h2 style="margin:20px">请输入修改信息</h1>
   <form action="${pageContext.request.contextPath }/menu.do" >
      <input type="hidden" name="method" value="update">
      <input type="hidden" name="mid"  value="${menu.mid}">
             <table align="center" cellpadding="0" cellspacing="0" border="1"
			width="600px">
			<tr align="center">
            <td height="30" align="center">菜单名称:</td>
             <td><input type="text" name="mname" value="${menu.mname }" style="margin:20px"></td>
             </tr>
             <tr align="center">
             <td height="30" align="center">菜单路径:</td>
              <td><input type="text" name="murl" value="${menu.murl }" style="margin:20px"></td>
              </tr>
              <tr align="center">
              <td height="30" align="center">父级菜单:</td>
           	 <td> <select name="mfid" style="margin:20px">
              <option value="0">权限管理</option>
              <option value="1">用户管理</option>
              <option value="1">角色管理</option>
              <option value="1">菜单管理</option>
              <option value="1">学生管理</option>
              <option value="1">教师管理</option>
              <option value="1">成绩管理</option>
              <option value="1">课程管理</option>
              <option value="1">审核管理</option>
              <c:forEach items="${menulist }" var="m">
                 <c:if test="${m.mfid==0 }">
                      <option value="${m.mid }" ${m.mid==menu.mfid?"selected":"" }>${m.mname }</option>
                 </c:if>
              </c:forEach>
              </select>
              </td></tr>
              <tr align="center">
              <td height="30" align="center">所属模块:</td>
               <td><select name="mrank" style="margin:20px">
                 <option value="1">权限管理</option>
              	<option value="2">用户管理</option>
             	<option value="3">角色管理</option>
              	<option value="4">菜单管理</option>
            	<option value="5">学生管理</option>
              	<option value="6">教师管理</option>
              	<option value="7">成绩管理</option>
              	<option value="8">课程管理</option>
              	<option value="9">审核管理</option>
              </select> 
              </td>
              <input type="hidden" name="mstate" value="${menu.mstate }">
              <input type="hidden" name="mdel" value="${menu.mdel }">
              </tr>
      			 <tr align="center">
				<td height="30" align="center">操作</td>
				<td height="30" align="center"><input type="submit"
					value="修改"> &nbsp;&nbsp; <input type="reset" value="重置" /></td>
				</tr>
				</table>
   </form>
   </center>
	
</body>
</html>