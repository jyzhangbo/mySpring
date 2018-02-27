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

    <div> 用户详情 </div>
    <div>

        ID: ${user.id} </br>
        NAME: ${user.name} </br>
        ADDRESS: ${user.address} </br>
        AGE: ${user.age}

    </div>

</body>
</html>
