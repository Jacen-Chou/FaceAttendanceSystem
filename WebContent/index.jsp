<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>USTB-Dang Dang人脸识别考勤系统（教师端）</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

	function login() {
		var teaid = document.getElementById("teaid").value;
		var teapassword = document.getElementById("teapassword").value;

		//alert(teaid);
		//alert(teapassword);
		
		if (teaid == "用户名" || teapassword == "") {
			alert("请输入账号或密码！");
			return false;
		} else {
			document.getElementById("login_form").submit();
		}
	}

</script>

</head>

<body>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>USTB-Dang Dang人脸识别考勤系统<br>（教师端）</p>
          </div>
          <form method="post" action="TeaLoginServlet" id="login_form" name="login_form">
				<c:choose>  
   					<c:when test="${empty teaid}">
   						<input id="teaid" name="teaid" type="text" value="用户名" onfocus="if(this.value=='用户名'){this.value=''}" onblur="if(this.value==''){this.value='用户名'}">
   					</c:when>  
   					<c:otherwise>
   						<input id="teaid" name="teaid" type="text"  value="${teaid}" onfocus="if(this.value=='用户名'){this.value=''}" onblur="if(this.value==''){this.value='用户名'}">
   					</c:otherwise>  
				</c:choose>
                <span id="password_text" onclick="this.style.display='none';document.getElementById('teapassword').style.display='block';document.getElementById('teapassword').focus().select();" >密码</span>
				<input id="teapassword" name="teapassword" type="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
          <div>
			<a><input value="登录" style="width:40%;float:left;margin-right:5px" type="button" onclick="login()"></a>
			<a href="TeaRegister.jsp"><input value="注册" style="width:40%;float:right;margin-left:5px" type="button"></a>
		  </div>  
		  </form>                      
      </div>
      <footer class="copyright">USTB生产实习——人脸识别考勤项目小组 版权所有©2018</footer>
</div>

</body>
</html>
