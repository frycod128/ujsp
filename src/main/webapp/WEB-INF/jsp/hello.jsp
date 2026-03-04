<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot JSP 示例</title>
    <style>
        body {
            font-family: 'Microsoft YaHei', sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
        }
        h1 {
            color: #ffd700;
            border-bottom: 2px solid #ffd700;
            padding-bottom: 10px;
        }
        .message {
            font-size: 18px;
            margin: 20px 0;
            padding: 15px;
            background: rgba(255, 255, 255, 0.2);
            border-radius: 8px;
        }
        .time {
            color: #98fb98;
            font-weight: bold;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            padding: 10px;
            margin: 5px 0;
            background: rgba(255, 255, 255, 0.15);
            border-radius: 5px;
            transition: transform 0.3s;
        }
        li:hover {
            transform: translateX(10px);
            background: rgba(255, 255, 255, 0.25);
        }
        .footer {
            margin-top: 30px;
            text-align: center;
            color: #ddd;
            font-size: 14px;
        }
        a {
            color: #ffd700;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
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