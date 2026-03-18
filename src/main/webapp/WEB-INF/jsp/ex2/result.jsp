<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>猜数字游戏 - 结果</title>
</head>
<body>
<h2>猜数字游戏 - 结果</h2>

<%
    // 获取用户提交的猜测
    String guessStr = request.getParameter("guess");

    if(guessStr == null || guessStr.trim().isEmpty()) {
        response.sendRedirect("inputGuess.jsp");
        return;
    }

    int userGuess = Integer.parseInt(guessStr);

    // 从session获取目标数字
    Integer targetNumber = (Integer)session.getAttribute("targetNumber");

    // 获取当前猜测次数
    Integer guessCount = (Integer)session.getAttribute("guessCount");
    if(guessCount == null) {
        guessCount = 0;
    }

    // 增加猜测次数
    guessCount++;
    session.setAttribute("guessCount", guessCount);

    if(targetNumber == null) {
        response.sendRedirect("inputGuess.jsp");
        return;
    }

    // 判断猜测结果
    if(userGuess == targetNumber) {
        // 记录结束时间
        session.setAttribute("endTime", System.currentTimeMillis());
        // 猜中，重定向到success.jsp
        response.sendRedirect("success.jsp");
    } else {
        // 猜错，给出提示
        String hint = "";
        if(userGuess > targetNumber) {
            hint = "猜大了！";
        } else {
            hint = "猜小了！";
        }

        // 保存提示信息到session
        session.setAttribute("message", hint + " 你已经猜了 " + guessCount + " 次，继续努力！");
%>

<p style="color: red;"><%= hint %></p>
<p>你已经猜了 <%= guessCount %> 次</p>

<%
    }
%>
</body>
</html>