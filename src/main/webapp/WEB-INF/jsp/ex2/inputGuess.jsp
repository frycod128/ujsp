<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>猜数字游戏 - 输入猜测</title>
</head>
<body>
<h2>猜数字游戏</h2>

<%
    // 生成1-100之间的随机整数
    int randomNumber = (int)(Math.random() * 100) + 1;

    // 将随机数存入session
    session.setAttribute("targetNumber", randomNumber);
    out.print(randomNumber);

    // 初始化猜测次数为0
    session.setAttribute("guessCount", 0);

    // 记录开始猜测时间
    session.setAttribute("startTime", System.currentTimeMillis());

    // 获取提示信息（如果有）
    String message = (String)session.getAttribute("message");
    if(message != null) {
        out.println("<p style='color: blue;'>" + message + "</p>");
        session.removeAttribute("message");
    }
%>

<p>我已经想好了一个1-100之间的整数，请你猜一猜是多少？</p>

<form action="result.jsp" method="post">
    <label for="guess">请输入你的猜测（1-100）：</label>
    <input type="number" id="guess" name="guess" min="1" max="100" required>
    <input type="submit" value="猜">
</form>
</body>
</html>