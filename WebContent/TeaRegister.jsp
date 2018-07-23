<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>注册页面</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

	function register() {
		var teaid = document.getElementById("teaid").value;
		var teaname = document.getElementById("teaname").value;
		var teapassword = document.getElementById("teapassword").value;
		var teaemail = document.getElementById("teaemail").value;
		var teaphone = document.getElementById("teaphone").value;
		
		if (teaid == "工号" || teaname == "姓名" || teapassword == "" || teaemail == "邮箱" || teaphone == "手机号") {
			alert("请输入所有内容！");
			return false;
		} else {
			document.getElementById("register_form").submit();
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
               <p>USTB-Dang Dang人脸识别考勤系统<br>（教师注册）</p>
          </div>
          <form method="post" action="TeaRegisterServlet" id = "register_form" name = "register_form">
          		<input id="teaid" name="teaid" type="text"  value="工号" onfocus="if(this.value=='工号'){this.value=''}" onblur="if(this.value==''){this.value='工号'}">
                <input id="teaname" name="teaname" type="text"  value="姓名" onfocus="if(this.value=='姓名'){this.value=''}" onblur="if(this.value==''){this.value='姓名'}">
                <span id="password_text" onclick="this.style.display='none';document.getElementById('teapassword').style.display='block';document.getElementById('teapassword').focus().select();" >密码</span>
			    <input id="teapassword" name="teapassword" type="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
			    <input id="teaemail" name="teaemail" type="text" value="邮箱" onfocus="if(this.value=='邮箱'){this.value=''}" onblur="if(this.value==''){this.value='邮箱'}">
			    <input id="teaphone" name="teaphone" type="text" value="手机号" onfocus="if(this.value=='手机号'){this.value=''}" onblur="if(this.value==''){this.value='手机号'}">
          
          <div>
			<a><input value="注册" style="width:40%;float:left;margin-right:5px" type="button" onclick="register()"></a>
			<a href="index.jsp"><input value="返回" style="width:40%;float:right;margin-left:5px" type="button"></a>
		  </div>  
		  </form>                      
      </div>
      <footer class="copyright">USTB生产实习——人脸识别考勤项目小组 版权所有©2018</footer>
</div>

</body>
</html>
