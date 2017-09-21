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
    <title>真厉害战队积分系统</title>
    <!--引入bootstrap样式--> 
    <!-- Loading Bootstrap -->
    <link href="/wechat/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="/wechat/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="/wechat/img/favicon.ico">

</head>
<body style="background-color: #fff;">

      <nav class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-3">
            <span class="sr-only">Toggle navigation</span>
          </button>
          <a class="navbar-brand" href="#">战队积分系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-3">
          <ul class="nav navbar-nav">
            <li><a href="#">系统消息<span class="navbar-unread">2</span></a></li>
            <li class="active"><a href="#">本周赛事</a></li>
            <li class="active"><a href="/wechat/signIn">报名参赛</a></li>
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
            <li><a href="/wechat/views/admin.jsp"><span class="visible-sm visible-xs">后台管理<span class="fui-gear"></span></span><span class="visible-md visible-lg"><span class="fui-gear"></span></span></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>
<div class="container-fluid">

	<div class="row-fluid">
		<div class="span12">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							排名
						</th>
						<th>
							玩家【id】
						</th>
						<th>
							当前积分
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${playerList}" var="p" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${p.name}[${p.id}]</td>
						<td>${p.point}</td>
					
					</tr>
					</c:forEach>
				</tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-4"><button class="btn btn-embossed btn-success" onclick="javascript:window.location.href='/wechat/signIn'">报名参赛</button></div>
        <div class="col-xs-4"><button class="btn btn-embossed btn-info" onclick="location='/wechat/match'">本周赛事</button></div>
         <div class="col-xs-4"><button class="btn btn-embossed btn-primary" onclick="location='/wechat/views/admin.jsp'">系统管理</button></div> 
    </div>
    
</div>

</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/wechat/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/wechat/js/flat-ui.min.js"></script>
	<script src="/wechat/js/dropload.min.js"></script>
    <script src="/wechat/js/application.js"></script>
</body>
</html>