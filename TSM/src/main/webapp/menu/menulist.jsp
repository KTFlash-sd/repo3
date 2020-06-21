<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}">
<meta charset="UTF-8">
<title>显示所有用户</title>
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
  <td >
    当前位置:权限管理>>菜单管理
 </td>
  <td>
    <input type="button"class="coolbg np" onClick="location='${pageContext.request.contextPath }/menu/addmenu.jsp';"  value='添加菜单' />
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
          
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type="text" id="filterName">
        </td>
        
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table  id="one" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath }/skin/images/tbg.gif">&nbsp;菜单列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" class="kk">
	<td width="10%">选择</td>
	<td width="10%">序号</td>
	<td width="10%">菜单名称</td>
	<td width="18%">菜单路径</td>
	<td width="10%">父级菜单</td>
	<td width="10%">所属模块</td>
	<td width="10%">状态</td>
	<td width="18%">操作</td>
</tr>
<c:forEach items="${menus }" var="menu">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="mid" type="checkbox" id="mid" value="101" class="np"></td>
	 
	    <td width="10%">${menu.mid }</td>
	    <td width="10%">${menu.mname }</td>
	    <td width="18%">${menu.murl }</td>
	    <td width="10%">
	     <c:forEach items="${menulist}" var="m">
	         <c:if test="${menu.mfid==m.mid }">
	             ${m.mname }
	          </c:if>
	      </c:forEach>
	      ${menu.mfid==0?"顶级菜单":"" }
	    </td>
	    <td width="10%">${menu.mrank==1?"权限管理":(menu.mrank==2?"用户管理":(menu.mrank==3?"角色管理":(menu.mrank==4?"菜单管理":(menu.mrank==5?"教师管理":(menu.mrank==6?"成绩管理":(menu.mrank==7?"课程管理":(menu.mrank==8?"审核管理":"其他"))))))) }</td>
	    <td width="10%">${menu.mstate==0?"已废弃":(menu.mstate==1?"已启用":"未启用") }</td>

	<td>
	<a href="${pageContext.request.contextPath }/menu.do?method=delete&mid=${menu.mid }&thispage=${pagebean.thispage }" onclick="return confirm('确认删除吗？')">删除</a> |
	<a href="${pageContext.request.contextPath }/menu.do?method=select&mid=${menu.mid}">编辑</a>
	</td>
</tr>
</c:forEach>


<tr bgcolor="#FAFAF1" class="kk">
<td height="28" colspan="12" >
	&nbsp;
	<input type="button" name="checkall"  id="checkall" value="全选"  onclick="one()">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" name="checkNo"  id="checkNo" value="全不选"  onclick="noall()">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" name="checkReverse"  id="checkReverse" value="反选"  onclick="isall()"></a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA" class="kk">
	<td height="36" colspan="8" align="center">
	  共${pagebean.totalsize }条/每页${pagebean.pagesize }条
	 共${pagebean.totalpage }页/第${pagebean.thispage }页
	 <a href="${pageContext.request.contextPath }/menu.do?method=query&thispage=1">[首页]</a> 
	 <a href="${pageContext.request.contextPath }/menu.do?method=query&thispage=${pagebean.thispage-1}" >[上一页]</a>
	 <a href="${pageContext.request.contextPath }/menu.do?method=query&thispage=${pagebean.thispage+1}" >[下一页]</a>
	 <a href="${pageContext.request.contextPath }/menu.do?method=query&thispage=${pagebean.getTotalpage()}">[末页]</a>
    </td>
</tr>
</table>
</form> 
<script>
		$(function () {
 		//设置列表查询
 		$("#filterName").blur(function () {
 		 $("#one tbody tr").not($(".kk")).stop().hide() //将tbody中的tr都隐藏
  	 	.filter(":contains('"+($(this).val())+"')").show(); //，将符合条件的筛选出来
 		});
		});
		// 处理全选
		
       function one(){
		/*************************************************/			
			// 获取所有的复选框
			var checkElements=document.getElementsByName('mid');
			for(var i=0;i<checkElements.length;i++){
				var checkElement=checkElements[i];
				// 方法一
				// checkElement.setAttribute('checked',' checked');
				// 方法二
				checkElement.checked=true;
				}
			}
		
		/*************************************************/
		// 处理全不选
		 function noall(){
			// 获取所有的复选框
			var checkElements=document.getElementsByName('mid');
			for(var i=0;i<checkElements.length;i++){
				var checkElement=checkElements[i];
				// 方法一火狐不支持
				// checkElement.setAttribute('checked',null);
				// 方法二 火狐和ie都支持
				checkElement.checked=false;
			}
		}
/******************************************************************/
		//反选
		 function isall(){
			// 获取所有的复选框
			var checkElements=document.getElementsByName('mid');
			for(var i=0;i<checkElements.length;i++){
				var checkElement=checkElements[i];
				if (checkElement.checked) {
					checkElement.checked=false;
				}
				else{
					checkElement.checked=true;
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