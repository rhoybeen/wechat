<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
	<style type="text/css">
	h1 {background-color: #00ff00}
	div.center {text-align:center; }
	input.fixedwidth {width:160px;}
	
	</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!--页面标题-->
    <title>完善您的个人信息</title>
    <!--引入bootstrap样式--> 
    
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
    
</head>
<body>

<div class="container-fluid" style="margin-top:20px;">
	<div class="row-fluid">
		<div class="span12">
			<form action="registry" method="POST" id="InfoForm">
				<div>
				<label>姓名： </label><input type="text" name="name" required="required" class="fixedwidth"/>
				</div>
				<div>
				<label>性别： </label>
				<select name="gender" required="required">
						<option value="">请选择</option>
						<option value="0">男</option>
						<option value="1">女</option>
				</select>
				</div>
				<div>
				<label>学校： </label><input type="text" name="school" required="required" class="fixedwidth"/>
				</div>
				<div>
				<label>邮箱： </label><input type="text" name="email" required="required" class="fixedwidth"/>
				</div>
				<div>
				<label>手机： </label><input type="text" name="phone" required="required" class="fixedwidth"/>
				</div>
				<div>
				<label>支付宝： </label><input type="text" name="alipay" required="required" placeholder="跳过填写‘无’" class="fixedwidth"/>
				</div>
				<div>
				<label>收件地址： </label><textarea name="address" required="required" style="width:200px;height:80px;"></textarea>
				</div>
			<div class="center">
              <label class="checkbox" for="checkbox1">
              <input type="checkbox" data-toggle="checkbox" value="" id="checkbox1" required="required" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
              	勾选同意
            </label>
		 	<button type="button" class="btn btn-primary" onclick="submitInfo()"> 提交 </button>
			</div>

			</form>
		</div>
	</div>
</div>
<script>

function getRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

function submitInfo()
{
	var request = new Object();
	request = getRequest();
  	var openid = request['openid'];

   	document.getElementById("InfoForm").action="registry"+"?openid="+openid;
  	document.getElementById("InfoForm").submit();
}
</script>

<!--引入jquery脚本-->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js"></script>
<!--引入bootstrap脚本-->
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<!-- 引入flatUI -->
<script src="https://cdn.bootcss.com/flat-ui/2.3.0/js/flat-ui.js"></script>
</body>
</html>