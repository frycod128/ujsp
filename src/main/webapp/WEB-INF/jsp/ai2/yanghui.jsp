<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>杨辉三角结果</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>杨辉三角形</h2>

<%
    Object nObj = request.getAttribute("n");
    Integer n = null;
    if (nObj != null) {
        n = Integer.parseInt(nObj.toString());
    }

    if (n == null || n <= 0 || n > 20) {
%>
<p>请输入1到20之间的有效整数！</p>
<a href="index">返回重新输入</a>
<%
} else {
    int[][] triangle = new int[n][];
    for (int i = 0; i < n; i++) {
        triangle[i] = new int[i + 1];
        triangle[i][0] = 1;
        triangle[i][i] = 1;
        for (int j = 1; j < i; j++) {
            triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
        }
    }
%>
<table border="1">
    <%
        for (int i = 0; i < n; i++) {
            out.println("<tr>");
            for (int j = 0; j <= i; j++) {
                out.println("<td>" + triangle[i][j] + "</td>");
            }
            out.println("</tr>");
        }
    %>
</table>
<%
    }
%>

<div>
    <h3>友情链接</h3>
    <p>
        <c:forEach items="${sessionScope.siteLinks}" var="entry">
            <c:url value="${entry.value}" var="encodedUrl" />
            <a href="${encodedUrl}" target="_blank">${entry.key}</a>
            &nbsp;&nbsp;
        </c:forEach>
    </p>
    <p>(点击链接将在新窗口打开)</p>
</div>

<p><a href="index">返回重新输入</a></p>
</body>
</html>