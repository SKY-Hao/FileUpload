<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <form method="post" enctype="multipart/form-data" action="/upload">
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form>

        <br>
    多个文件上传
    <form method="post" enctype="multipart/form-data" action="/uploads">
        文件1<input type="file" name="file">
        文件2<input type="file" name="file">
        文件3<input type="file" name="file">

        <input type="submit" value="提交多个">
    </form>


</body>
</html>
