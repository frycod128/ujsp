<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP导航</title>
</head>
<body>
<h2>导航菜单</h2>

<!-- Homework 区域 -->
<h3>Homework</h3>
<form action="homework/1.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /1</button>
</form>
<form action="homework/2.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /2</button>
</form>
<form action="homework/3.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /3</button>
</form>

<!-- Experiment 区域 -->
<h3>Experiment</h3>
<form action="ex1/index.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /ex1</button>
</form>
<form action="ex2/inputGuess.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /ex2</button>
</form>
<form action="ex3/index.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /ex3</button>
</form>

<!-- Other 区域 -->
<h3>Other</h3>
<form action="https://github.com/frycod128/ujsp/" style="display: inline;">
    <button type="submit">跳转到 GitHub 仓库</button>
</form>
<form action="hello.jsp" method="get" style="display: inline;">
    <button type="submit">跳转到 /hello</button>
</form>

<hr>
<p>当前时间: <%= new java.util.Date() %></p>
</body>
</html>