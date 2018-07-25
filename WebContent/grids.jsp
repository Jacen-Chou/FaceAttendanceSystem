<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<li><a href="form_layouts3.jsp" class="mws-i-24 i-cog-3">设置考勤IP</a></li>
					<li><a href="TeaPersonInfoServlet.do?teaid=${ sessionScope.teaid }" class="mws-i-24 i-user">个人信息</a></li>
					<li><a href="form_layouts2.jsp" class="mws-i-24 i-key-2">修改密码</a></li>
				</ul>
			</div>
			<!-- End Navigation -->

		</div>
        
        <div id="mws-container" class="clearfix">
            <div class="container">
            

                
                <div class="clear"></div>
                
            	<div class="mws-panel grid_2">
                	<div class="mws-panel-header">
                    	<span>工号</span>
                    </div>
                    <div class="mws-panel-body">
                    	<div class="mws-panel-content"><span>${ teacher.teaid }</span>
                        </div>
                    </div>
                </div>
                
                <div class="clear"></div>
                <div class="mws-panel grid_2">
                	<div class="mws-panel-header">
                    	<span>姓名</span>
                    </div>
                    <div class="mws-panel-body">
                    	<div class="mws-panel-content"><span>${ teacher.teaname }</span>
                        </div>
                    </div>
                </div>
                
                <div class="clear"></div>
                <div class="mws-panel grid_2">
                	<div class="mws-panel-header">
                    	<span>邮箱</span>
                    </div>
                    <div class="mws-panel-body">
                    	<div class="mws-panel-content"><span>${ teacher.teaemail }</span>
                        </div>
                    </div>
                </div>
                
                <div class="clear"></div>
                <div class="mws-panel grid_2">
                	<div class="mws-panel-header">
                    	<span>手机号</span>
                    </div>
                    <div class="mws-panel-body">
                    	<div class="mws-panel-content"><span>${ teacher.teaphone }</span>
                        </div>
                    </div>
                </div>
                
                <div class="clear"></div>
			<!-- Footer -->
				<div id="mws-footer">USTB生产实习——人脸识别考勤项目小组 版权所有©2018</div>
			<!-- End Footer -->
                
            </div>

        </div>
    </div>


</body>
</html>
