<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/2/7
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login page</title>
</head>
<body onload="document.f.username.focus()">

    <div> login </div>
    <div>
        <sf:form method="post" action="/mylogin">
            name:<input type="text" name="username" /><br/>
            password:<input type="password" name="password"/><br/>
            <input type="submit" name="submit" value="login"><br/>
            <input type="checkbox" name="remember-me" id="remember_me">remember me
        </sf:form>
    </div>
    <br/>

</body>
</html>
