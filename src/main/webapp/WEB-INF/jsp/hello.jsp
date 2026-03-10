<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot JSP 示例</title>
</head>
<body>
<div class="container">
    <h1>Spring Boot + JSP 示例</h1>

    <div class="message">
        <strong>消息：</strong> ${message}
    </div>

    <div class="message">
        <strong>你好：</strong> ${name}
    </div>

    <div>
        <strong>当前时间：</strong>
        <span class="time">${time}</span>
    </div>

    <h2>技术列表：</h2>
    <ul>
        <c:forEach items="${items}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>

    <div class="footer">
        <p>这是一个使用 Spring Boot 和 JSP 构建的简单应用</p>
        <p><a href="/">返回首页</a> | <a href="/hello?name=Spring Boot">带参数访问</a></p>
    </div>
</div>
</body>
</html>