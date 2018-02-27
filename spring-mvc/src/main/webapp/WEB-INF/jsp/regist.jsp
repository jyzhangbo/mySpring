<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/2/7
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>users</title>
</head>
<body>

    <div> 用户注册 </div>
    <div>
        <form method="post">
            name : <input type="text" name="name" id="name">
            address : <input type="text" name="address" id="address">
            age : <input type="text" name="age" id="age">
            <input type="submit" value="注册">
        </form>

    </div>

</body>
</html>
