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
    <title>报名本周积分赛</title>
    <!--引入bootstrap样式--> 
    
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">    
    <link href="https://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">

</head>
<body style="background-color: #fff;">
<div class="container-fluid">
	<div class="row-fluid" style="margin:10px;">
		<div class="span12">
			<form id="form">
				<fieldset>
					 <legend>输入您的玩家id报名</legend>
					 <div>
					 	<input type="number" class="form-control" placeholder="玩家id可在主页选手名称后找到。" name="playerId"/>
					 </div>
					 <div>
						<label class="checkbox" for="checkbox1">
			              <input type="checkbox" data-toggle="checkbox" value="" id="checkbox1" required="required" class="custom-checkbox">
			              <span class="icons"><span class="icon-unchecked">
			              </span><span class="icon-checked"></span></span>
			              	再次确认您的id无误
			            </label>
					 </div>
					 
					<div>
						<button class="btn btn-primary" onclick="sub()">本周参赛</button>
						<a href="/wechat/pvp"><em>返回首页</em></a>
					</div>

				</fieldset>
			</form>
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
<script>
function sub(){
	console.log("submit by ajax");
	$.ajax({  
        type: "POST",  
        url:"/wechat/signIn",  
        data:$('#form').serialize(),// 序列化表单值  
        async: false,  
        error: function(request) {  
            alert("连接错误");  
        },  
        success: function(data) {  
        	
            alert(data.status);
        }  
    });  
	return false;
}
</script>
</body>
</html>