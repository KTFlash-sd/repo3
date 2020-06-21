<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>显示所有用户</title>
<style type="text/css">
body
  {
  background-color:#CCEEFF;
  }
</style>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/css/base.css">
</head>
<%--  	<%
	String rid=request.getParameter("rid");
 	String rname=request.getParameter("rname");
	%> --%>
<body>
    <form action="${pageContext.request.contextPath }/role.do" id="f">
     <input type="hidden" name="method" value="updateRM">
     <input type="hidden" name="rid" value="${role.rid}">
    <span>当前角色:<input name="rname" value="${role.rname}"  ></span> 
    <hr color="yellow">
    <h3>所拥有的权限为:</h3>
       
       <table  width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCDDFF"  style="margin-top:8px">
        <c:forEach items="${menulist}" var="menu">
            <c:if test="${menu.mfid==0}">
             <tr>
                <td>
                <input type="checkbox" name="mid" value="${menu.mid }" id="fmid"
                  <c:forEach items="${rmenu}" var="rm">
                      ${rm.mid==menu.mid?"checked":"" }
                  </c:forEach>
                 > 
                ${menu.mname }
                 <ul>
                 <c:forEach items="${menulist }" var="m"> 
                  <c:if test="${m.mfid==menu.mid}">
                   <li>&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="checkbox" name="mid" value="${m.mid }" id="cmid"
                     <c:forEach items="${rmenu}" var="rm">
                      ${rm.mid==m.mid?"checked":""}
                     </c:forEach>
                   >${m.mname }
                   <li>
                  </c:if>
                </c:forEach>
                 </ul>
                </td>
             </tr>
            </c:if>
        </c:forEach> 
       </table>
       <input type="submit" value="确定修改">
     
    </form>
    
    <script>
       $(function(){
    	   $("[id=fmid]").click(function(){
    		   $(this).siblings("ul").find(":checkbox").prop('checked',$(this).prop('checked'));
    	   });
    	   
    	   $("[id=cmid]").click(function(){
    		   var m=$(this).parents("ul").prev();
    		   var result= $(this).parents("ul").find(":checkbox").is(":checked");
    		   m.prop('checked',result);
    	   });
    	   
    	   $("#f").submit(function(){
    		   window.close();
    	   });
       });
    </script>
</body>
</html>