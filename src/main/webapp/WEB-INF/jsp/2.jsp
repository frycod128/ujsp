<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面2</title>
</head>
<body>
<h2>这是页面 2</h2>
<p>当前地址: /2</p>

<form action="../" method="get" style="display: inline;">
    <button type="submit">返回首页</button>
</form>

<form action="../1" method="get" style="display: inline;">
    <button type="submit">跳转到 /1</button>
</form>

<form action="../3" method="get" style="display: inline;">
    <button type="submit">跳转到 /3</button>
</form>

<hr>
<p>页面2的内容示例</p>
<p>当前时间: <%= new java.util.Date() %></p>
</body>
</html>