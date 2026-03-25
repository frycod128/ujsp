<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>计算结果</title>
</head>
<body>
<h2>计算结果</h2>
<%
    String username = (String) request.getAttribute("username");
    Integer start = (Integer) request.getAttribute("start");
    Integer end = (Integer) request.getAttribute("end");
    List<Integer> resultList = (List<Integer>) request.getAttribute("resultList");

    if (username != null && start != null && end != null && resultList != null) {
%>
<p>用户名：<%= username %></p>
<p>区间 [<%= start %>, <%= end %>] 内各位数字之和等于6的整数：</p>
<%
    if (resultList.isEmpty()) {
%>
<p>该区间内没有符合条件的整数。</p>
<%
} else {
%>
<p>
    <%
        for (int i = 0; i < resultList.size(); i++) {
            out.print(resultList.get(i));
            if (i < resultList.size() - 1) {
                out.print(", ");
            }
        }
    %>
</p>
<%
    }
%>
<br/>
<a href="<%= request.getContextPath() %>/ex3/index.jsp">返回</a>
<%
    } else {
        response.sendRedirect(request.getContextPath() + "/ex3/index.jsp");
    }
%>
</body>
</html>