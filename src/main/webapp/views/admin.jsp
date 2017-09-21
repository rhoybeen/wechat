<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
	<style type="text/css">
	div[id^="mode"] {display:none;}
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
							玩家id
						</th>
						<th>
							昵称
						</th>
						<th>
							积分
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="table_player">
				</tbody>
						</table>
			<div class="row">
				<hr>
				<form>
				
        		<div class="col-xs-4"><input placeholder="用户名" id="input_name" class="form-control"></input></div>
       			<div class="col-xs-4"><input placeholder="积分" id="input_point" class="form-control"></input></div>
				<div class="col-xs-4"><button class="btn" onclick="createPlayer()">创建用户</button></div>
					
				</form>
			</div>
    </div>
    <div class="span12" id="modeSignIn" >
    		报名情况
    </div>
    <div class="span12" id="modeHistory" >
    历史赛绩
    </div>
</div>
		


</div>

<script>
function test(){
	$.ajax({
		type:'GET',
		url:"/wechat/db?action=query",
		success:function(obj){

			var table = $("#table_player");
			table.empty();
			var tbody = "";
			$.each(obj,function(index,item){
				tbody = "<tr><td>"+(index+1)+"</td><td>"+item.name+item.id+"</td><td>"+item.point+"</td><td><small><a href=\"###\" onclick=\"del(" + item.id + ");return false\">删除</a> <a href=\"###\" onclick=\"alter(" + item.id + ");return false\">编辑</a></small></td></tr>";
				table.append(tbody);
			});

		}
	});
}


function del(mem_id){
	if(!confirm("确认要删除？")){ 
		window.event.returnValue = false; 
		}else{
			$.ajax({
				type:'POST',
				url:"/wechat/db?action=del&mem_id="+mem_id,
				success:function(data){
					alert("删除成功");
					test();
				}
			});
		}
}

function alter(mem_id){
	var point = prompt("修改积分","");
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
	}
}

function switch_mode(mode){
	switch(mode){
		case 1: 
			$("#modePlayer").show();
			$("#modeSignIn").hide();
			$("#modeHistory").hide();
			break;
		case 2: 
			$("#modePlayer").hide();
			$("#modeSignIn").show();
			$("#modeHistory").hide();
			break;
		case 3: 
			$("#modePlayer").hide();
			$("#modeSignIn").hide();
			$("#modeHistory").show();
			break;	}
	
}
</script>

<!--引入jquery脚本-->
<script src="/wechat/js/jquery.min.js"></script>
<script>
$(document).ready(function(){
	switch_mode(1);
	test();
});

</script>
<script src="/wechat/js/dropload.min.js"></script>
<script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js"></script>
<!--引入bootstrap脚本-->
 <!-- <script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>  -->
<!-- 引入flatUI -->
<script src="/wechat/js/flat-ui.min.js"></script>

</body>
</html>