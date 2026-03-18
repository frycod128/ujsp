<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>猜数字游戏 - 成功</title>
</head>
<body>
<h2>恭喜你，猜对了！</h2>

<%
    // 从session获取数据
    Integer targetNumber = (Integer)session.getAttribute("targetNumber");
    Integer guessCount = (Integer)session.getAttribute("guessCount");
    Long startTime = (Long)session.getAttribute("startTime");
    Long endTime = (Long)session.getAttribute("endTime");

    if(targetNumber == null || guessCount == null || startTime == null || endTime == null) {
        response.sendRedirect("inputGuess.jsp");
        return;
    }

    // 计算猜测耗时（秒）
    long timeSpent = (endTime - startTime) / 1000;
%>

<p>正确的数字是：<strong><%= targetNumber %></strong></p>
<p>你一共猜了：<strong><%= guessCount %></strong> 次</p>
<p>猜测用时：<strong><%= timeSpent %></strong> 秒</p>

</body>
</html>