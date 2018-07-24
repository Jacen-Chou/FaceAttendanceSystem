<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/fluid.css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/mws.style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/icons/icons.css" media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="css/demo.css" media="screen" />

<link rel="stylesheet" type="text/css" href="plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/jimgareaselect/css/imgareaselect-default.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="plugins/tipsy/tipsy.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css" href="plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/jui/jquery.ui.css" media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="css/mws.theme.css" media="screen" />

<!-- JavaScript Plugins -->

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

<script type="text/javascript" src="plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript" src="plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="plugins/jquery.filestyle.js"></script>
<script type="text/javascript" src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript" src="plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript" src="plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript" src="plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="plugins/jquery.validate.js"></script>
<script type="text/javascript" src="plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<script type="text/javascript" src="js/mws.js"></script>
<script type="text/javascript" src="js/demo.js"></script>
<script type="text/javascript" src="js/themer.js"></script>

<title>USTB-Dang Dang人脸识别考勤系统</title>

<script type="text/javascript">

	function modify_pass() {
		var old_pass = document.getElementById("old_pass").value;
		var new_pass = document.getElementById("new_pass").value;
		var confirm_new_pass = document.getElementById("confirm_new_pass").value;
		
		if (old_pass == "" || new_pass == "" || confirm_new_pass == "") {
			alert("请输入所有内容！");
			return false;
		} else if (new_pass != confirm_new_pass){
			alert("新密码两次输入不一样！");
			return false;
		} {
			document.getElementById("modify_password_form").submit();
		}
	}

</script>

</head>

<body>
<!-- Header Wrapper -->
	<div id="mws-header" class="clearfix">

		<!-- Logo Wrapper -->
		<div id="mws-logo-container">
			
				<h3 style="color:white">USTB-Dang Dang人脸识别考勤系统</h3>
			
		</div>

		<!-- User Area Wrapper -->
		<div id="mws-user-tools" class="clearfix">
			<!-- User Functions -->
			<div id="mws-user-info" class="mws-inset">
				<div id="mws-user-functions">
					<div id="mws-username">
						Hello, ${ sessionScope.teaname }(${ sessionScope.teaid })
					</div>
					<ul>
						<li><a href="TeaPersonInfoServlet.do?teaid=${ sessionScope.teaid }">个人信息</a></li>
						<li><a href="form_layouts2.jsp">修改密码</a></li>
						<li><a href="index.jsp">注销登陆</a></li>
					</ul>
				</div>
			</div>
			<!-- End User Functions -->
		</div>
	</div>

	<!-- Main Wrapper -->
	<div id="mws-wrapper">
		<!-- Necessary markup, do not remove -->
		<div id="mws-sidebar-stitch"></div>
		<div id="mws-sidebar-bg"></div>

		<!-- Sidebar Wrapper -->
		<div id="mws-sidebar">

			<!-- Main Navigation -->
			<div id="mws-navigation">
				<ul>
					<li class="active"><a href="dashboard.jsp" class="mws-i-24 i-home">主页</a></li>
					<li><a href="TeaClickCreateAttGroupServlet.do" class="mws-i-24 i-multiple-users">创建考勤组</a></li>
					<li><a href="TeaQueryAttGroup.do?teaid=${sessionScope.teaid }" class="mws-i-24 i-file-cabinet">我的考勤组</a></li>
					<li><a href="TeaQueryAtt.do" class="mws-i-24 i-day-calendar">查看考勤记录</a></li>
					<li><a href="TeaPersonInfoServlet.do?teaid=${ sessionScope.teaid }" class="mws-i-24 i-user">个人信息</a></li>
					<li><a href="form_layouts2.jsp" class="mws-i-24 i-key-2">修改密码</a></li>
				</ul>
			</div>
			<!-- End Navigation -->

		</div>

        
        <div id="mws-container" class="clearfix">
            <div class="container">
            	<div class="mws-panel grid_8">
                	<div class="mws-panel-header">
                    	<span class="mws-i-24 i-key-2">修改密码</span>
                    </div>
                    <div class="mws-panel-body">
                    	<form class="mws-form" action="TeaModifyPassServlet.do" id="modify_password_form" name="modify_password_form">
							<input type="hidden" name="teaid" value="${ sessionScope.teaid }"/>
                    		<div class="mws-form-inline">
                    			<div class="mws-form-row">
                    				<label>原密码</label>
                    				<div class="mws-form-item small">
                    					<input id="old_pass" name="old_pass" type="password" class="mws-textinput" />
                    				</div>
                    			</div>
                    			<div class="mws-form-row">
                    				<label>新密码</label>
                    				<div class="mws-form-item small">
                    					<input id="new_pass" name="new_pass" type="password" class="mws-textinput" />
                    				</div>
                    			</div>
                    			<div class="mws-form-row">
                    				<label>确认新密码</label>
                    				<div class="mws-form-item small">
                    					<input id="confirm_new_pass" name="confirm_new_pass" type="password" class="mws-textinput" />
                    				</div>
                    			</div>
                    		</div>
                    		<div class="mws-button-row">
                    			<input type="button" value="&nbsp;提&nbsp;交&nbsp;" class="mws-button green" style="margin-right:15px;" onclick="modify_pass()" />
                    			<input type="reset" value="&nbsp;清&nbsp;空&nbsp;" class="mws-button gray" />
                    		</div>
                    	</form>
                    </div>    	
                </div>
            <!-- Footer -->
			<div id="mws-footer">USTB生产实习——人脸识别考勤项目小组 版权所有©2018</div>
			<!-- End Footer -->
        </div>
    </div>


</body>
</html>
