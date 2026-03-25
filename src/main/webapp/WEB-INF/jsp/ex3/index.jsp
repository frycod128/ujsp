<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>实验3 - 数字之和判断</title>
</head>
<body>
<h2>请输入用户名和两个正整数</h2>
<%
    String errorMsg = (String) request.getAttribute("errorMsg");
    if (errorMsg != null && !errorMsg.isEmpty()) {
%>
<p style="color: red;"><%= errorMsg %></p>
<%
    }
%>
<form action="<%= request.getContextPath() %>/ex3/show.jsp" method="post">
    用户名：<input type="text" name="username" /><br/>
    整数1：<input type="text" name="num1" /><br/>
    整数2：<input type="text" name="num2" /><br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>