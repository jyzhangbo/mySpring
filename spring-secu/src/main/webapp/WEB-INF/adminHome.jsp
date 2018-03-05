<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>adminhome page</title>
</head>
<body>
<div>hello <security:authentication property="principal.username" /></div>
<div> admin home </div>
<div>

</div>
<br/>

</body>
</html>
