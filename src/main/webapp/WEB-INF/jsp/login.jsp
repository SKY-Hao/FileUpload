<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form method="get" action="/user/login">
        姓名：<input type="text" name="name">
        密码：<input type="password" name="password">
        <input type="submit" value="登录">

    </form>

</body>
</html>
