<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/2/7
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>websocket</title>
    <script type="text/javascript">
        var url='ws://'+window.location.host+'/message';
        var sock=new WebSocket(url);
        sock.onopen=function(){
            console.log('open');
            sayhi();
        };

        sock.onmessage=function (e) {
            console.log('receive:'+e.data);
            document.getElementById("uname").setAttribute("value",e.data);
            setTimeout(function () {
                sayhi()
            },2000);
        };

        sock.onclose=function(){
            console.log('close');
        };

        function sayhi() {
            console.log('send');
            sock.send("name");
        }

    </script>
</head>
<body>

hi!<input type="text" value="" name="uname" id="uname">
<label></label>

</body>
</html>
