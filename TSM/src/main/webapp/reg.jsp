<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); 
   String contextpath=request.getContextPath();
   String url=path+contextpath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=url%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>教学信息管理系统注册页面</title>
<style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    .code {
        width: 400px;
        margin: 0 auto;
    }
    
    #canvas {
    	margin: 10px;
        float:initial;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 5px;
        cursor: pointer;
    }
    .btn {line-height: 42px; 
    		margin: 15px auto 0px;
     		padding: 0 15px; 
     		border: 1px solid rgba(255, 255, 255, 0.38);
      		background: rgba(45, 45, 45, 0.33); 
      		border-radius: 6px;
      		}
    
	#select{
		margin: 10px;
		vertical-align: middle;
		float: left;
 		padding: 7px 16px;
 		box-shadow: inset 0 1px 1px rgba(0,0,0,0.075);
		 }
		 
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    .check{
    	width:20px;
    	height:20px;
    }
  </style>
  <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="js/jquery.min.js"></script>

<link rel="stylesheet" href="css/style.css" />
<body cz-shortcut-listen="true"  class="layui-layout-body">

<div class="register-container">
	<h1>教学信息管理系统注册</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
	</div>
	
	<form action="${pageContext.request.contextPath}/account.do" method="post"  id="registerForm">
	<input type="hidden" name="method" value="reg">
		<div>
			<input type="text" name="username" class="username" placeholder="您的用户名" autocomplete="off"/><br />
			<span id="s"></span>
			<input type="hidden" name="astate" value="1">
			<input type="hidden" name="adel" value="1">
			<label id="sb" style="color:red"></label><br>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<label  style="color:red" id="lb"></label>
		<span id="select">
			请选择您的角色:<input type="radio" name="check" class="check" value="2" oncontextmenu="return false" onpaste="return false" checked="checked"/><nobr>&nbsp;学生</nobr>
			<input type="radio" name="check" class="check" value="3" oncontextmenu="return false" onpaste="return false" /><nobr>&nbsp;教师</nobr>
			</span>
		<div class="layui-layer-move">
            <input type="text" value="" placeholder="请输入验证码（不区分大小写）"  oncontextmenu="return false"  onpaste="return false" class="input-val"/>
            <canvas id="canvas" width="110" height="45" ></canvas>
         	
        </div>
		<input  type="button"  class="btn"  value="注 册" >
	</form>
	<a href="mainlogin.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>
<script>

	
    	    
	    	$(function(){
	            var show_num = [];
	            draw(show_num);
	            
	            $("#canvas").on('click',function(){
	                draw(show_num);
	            })
	            $(".btn").on('click',function(){
	                var val = $(".input-val").val().toLowerCase();
	                var num = show_num.join("");
	                if(val==''){
	                    alert('请输入验证码！');
	                }else if(val == num){
	                    $(".input-val").val('');
	                    draw(show_num);
	                    $("#registerForm").submit();
	                }else{
	                        alert('验证码错误！请重新输入！');
	                        $(".input-val").val('');
	                        draw(show_num);
	                }
	            })
	        })

	        function draw(show_num) {
	            var canvas_width=$('#canvas').width();
	            var canvas_height=$('#canvas').height();
	            var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
	            var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
	            canvas.width = canvas_width;
	            canvas.height = canvas_height;
	            var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
	            var aCode = sCode.split(",");
	            var aLength = aCode.length;//获取到数组的长度
	            
	            for (var i = 0; i <= 3; i++) {
	                var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
	                var deg = Math.random() * 30 * Math.PI / 180;//产生0~30
	                var txt = aCode[j];//得到随机的一个内容
	                show_num[i] = txt.toLowerCase();
	                var x = 10 + i * 20;//文字在canvas上的x坐标
	                var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
	                context.font = "bold 23px 微软雅黑";

	                context.translate(x, y);
	                context.rotate(deg);

	                context.fillStyle = randomColor();
	                context.fillText(txt, 0, 0);

	                context.rotate(-deg);
	                context.translate(-x, -y);
	            }
	            for (var i = 0; i <= 5; i++) { //验证码上显示线条
	                context.strokeStyle = randomColor();
	                context.beginPath();
	                context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
	                context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
	                context.stroke();
	            }
	            for (var i = 0; i <= 30; i++) { //验证码上显示小点
	                context.strokeStyle = randomColor();
	                context.beginPath();
	                var x = Math.random() * canvas_width;
	                var y = Math.random() * canvas_height;
	                context.moveTo(x, y);
	                context.lineTo(x + 1, y + 1);
	                context.stroke();
	            }
	        }

	        function randomColor() {//得到随机的颜色值
	            var r = Math.floor(Math.random() * 256);
	            var g = Math.floor(Math.random() * 256);
	            var b = Math.floor(Math.random() * 256);
	            return "rgb(" + r + "," + g + "," + b + ")";
	        }
	    </script>


<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>