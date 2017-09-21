<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<style type="text/css">
	div.center {text-align:center; }
	input.fixedwidth {width:160px;}
	
	</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!--页面标题-->
    <title>报名失败</title>
    <!--引入bootstrap样式--> 
    
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">    
    <link href="https://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">

</head>
<body style="background-color: #fff;">
<div class="container-fluid">
	<div class="row-fluid" style="margin:10px;">
		<%=request.getAttribute("info")%>
		<div class="row">
		<button type="button" class="btn btn-success" style="margin-left:20px;" onclick="javascript:window.location.href='/wechat/pvp'">返回主页</button>
		<button type="button" class="btn btn-info" style="margin-left:20px;" onclick="javascript:window.location.href='/wechat/signIn'">重新报名</button>
		</div>
	</div>
</div>

<!--引入jquery脚本-->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js"></script>
<!--引入bootstrap脚本-->
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<!-- 引入flatUI -->
<script src="https://cdn.bootcss.com/flat-ui/2.3.0/js/flat-ui.js"></script>
</body>
</html>