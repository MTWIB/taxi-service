<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
<%@include file="../header.jsp" %>
</head>
<body>
<h1>Login page</h1>
<h4 style="color: red">${errorMsg}</h4>
<form method="post" action="${pageContext.request.contextPath}/login">
  <label>Login</label> <input type="text" name="login" required> <br>
  <label>Password</label> <input type="password" name="password" required> <br>
  <button type="submit">Login</button>
</form>
<h4><a href="${pageContext.request.contextPath}/drivers/add">Register</a></h4>
</body>
</html>
