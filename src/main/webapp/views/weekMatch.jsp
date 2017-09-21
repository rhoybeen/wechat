<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
	<style type="text/css">
	input {height:25px;width:100px;}
	</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!--页面标题-->
    <title>系统管理</title>
    <!--引入bootstrap样式--> 
	<link rel="shortcut icon" href="/wechat/img/favicon.ico">
    <link href="/wechat/css/bootstrap.min.css" rel="stylesheet">    
    <link href="/wechat/css/flat-ui.css" rel="stylesheet">

</head>
<body style="background-color: #fff;">
<div class="container">

<nav class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-3">
            <span class="sr-only">Toggle navigation</span>
          </button>
          <span class="navbar-brand" >控制台</span>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="navbar-collapse collapse" id="navbar-collapse-3" style="height: 2px;">
          <ul class="nav navbar-nav">
            <li><a href="###" onclick="switch_mode(1);">成员管理<span class="navbar-unread">1</span></a></li>
            <li><a href="###" onclick="switch_mode(2);">报名情况</a></li>
            <li><a href="###" onclick="switch_mode(3);">历史赛绩</a></li>
           </ul>
          <form class="navbar-form navbar-left" action="#" role="search">
            <div class="form-group">
              <div class="input-group">
                <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                <span class="input-group-btn">
                  <button type="submit" class="btn"><span class="fui-search"></span></button>
                </span>
              </div>
            </div>
          </form>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">MonsterCritic <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>
            <li><a href="#"><span class="visible-sm visible-xs">Settings<span class="fui-gear"></span></span><span class="visible-md visible-lg"><span class="fui-gear"></span></span></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
</nav>

<div class="row-fluid">
	<div class="span12" id="modePlayer" >
			<table class="table table-striped" id="table">
				<thead>
					<tr>
						<th>
							序号
						</th>
						<th>
							昵称
						</th>
						<th>
							ID
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="table_player">
				</tbody>
			</table>

    </div>

</div>
		


</div>
<script>
function test(){
	$.ajax({
		type:'GET',
		url:"/wechat/db?action=query&method=1",
		success:function(obj){
			console.log("get data from server")
			var table = $("#table_player");
			table.empty();
			var tbody = "";
			$.each(obj,function(index,item){
				tbody = "<tr><td>"+(index+1)+"</td><td>"+item.name+"</td><td>"+item.id+"</td><td><small><a href=\"###\" onclick=\"del(" + item.id + ");return false\">取消报名</a></small></td></tr>";
				table.append(tbody);
			});

		}
	});
}


function del(mem_id){
	if(!confirm("确认要取消报名？")){ 
		window.event.returnValue = false; 
		}else{
			$.ajax({
				type:'POST',
				url:"/wechat/db?action=del&method=1&mem_id="+mem_id,
				success:function(data){
					alert("取消成功");
					test();
				}
			});
		}
}

function alter(mem_id){
/* 	var point = prompt("修改积分","");
	if(point != null && point != ""){
		if(!isNaN(point)){
			$.ajax({
				type:'POST',
				url:"/wechat/db?action=alter&mem_id="+mem_id+"&point="+point,
				success:function(data){
					alert("修改成功");
					test();
				}
			});
		}else{
			alert("请输入一个数字");
		}
	} */
	alert("未开放");
}

</script>
<script>
window.onload=function(){ 
	test();
	} 
</script>

<!--引入jquery脚本-->
<script src="/wechat/js/jquery.min.js"></script>

<script src="/wechat/js/dropload.min.js"></script>
<script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js"></script>
<!--引入bootstrap脚本-->
 <!-- <script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>  -->
<!-- 引入flatUI -->
<script src="/wechat/js/flat-ui.min.js"></script>

</body>
</html>