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
    <title>users</title>
</head>
<body>

    <div> <s:message code="regist.message"></s:message></div>
    <div>
        <sf:form method="post" modelAttribute="user">
            name:<sf:input path="name" /><font color="red"><sf:errors path="name"/></font><br/>
            address:<sf:input path="address" /><br/>
            age:<sf:input path="age" /><br/>
            <input type="submit" value="注册">
        </sf:form>
    </div>
    <br/>

</body>
</html>
