<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP导航</title>
</head>
<body>
<h2>导航菜单</h2>
<p>点击下面的按钮跳转到对应的子地址：</p>

<form action="hello.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /hello</button>
</form>

<form action="1.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /1</button>
</form>

<form action="2.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /2</button>
</form>

<form action="3.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /3</button>
</form>

<form action="ex2/inputGuess.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /ex2</button>
</form>

<hr>
<p>当前时间: <%= new java.util.Date() %></p>
</body>
</html>