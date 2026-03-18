<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>最大公约数与最小公倍数</title>
</head>
<body>
<h2>计算两个随机整数的最大公约数和最小公倍数</h2>

<%!
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
%>

<%
    Random random = new Random();

    int num1 = random.nextInt(100) + 1;
    int num2 = random.nextInt(100) + 1;

    int gcdResult = gcd(num1, num2);
    int lcmResult = lcm(num1, num2);
%>

<p>随机整数1：<%= num1 %></p>
<p>随机整数2：<%= num2 %></p>
<p>最大公约数：<%= gcdResult %></p>
<p>最小公倍数：<%= lcmResult %></p>

<hr>
<p><a href="">刷新页面</a> 生成新的随机数</p>
</body>
</html>