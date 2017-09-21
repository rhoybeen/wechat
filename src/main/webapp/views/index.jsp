<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
  <head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!--页面标题-->
    <title>完善您的个人信息</title>
    <!--引入bootstrap样式--> 
    
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="bootstrap/css/flat-ui.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <form action="login.do" method="post">
    	userName:<input type="text" name="userName"/><br/>
    	passWord:<input type="password" name="userPwd"/><br/>
    	<input type="submit" value="Login"/><input type="reset" value="reset"/>
    </form>
    ${error }
  </body>
  
  <!--引入jquery脚本-->
<script src="<%=basePath%>bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<!--引入bootstrap脚本-->
<script src="<%=basePath%>bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="<%=basePath%>bootstrap/js/flat-ui.js" type="text/javascript"></script>
</html>