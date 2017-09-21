<html>
  <head>
    
    <title>My JSP 'Main.jsp' starting page</title>
    
  </head>
  
  <body>
    <form action="login.do" method="post">
    	userName:<input type="text" name="userName"/><br/>
    	passWord:<input type="password" name="userPwd"/><br/>
    	<input type="submit" value="Login"/><input type="reset" value="reset"/>
    </form>
    ${error }
  </body>
</html>