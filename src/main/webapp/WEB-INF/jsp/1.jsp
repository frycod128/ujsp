<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP语法基础</title>
</head>
<body>
<h2>随机产生1百万个1~6的整数，分别统计1~6出现的次数。</h2>
<%
    Random random = new Random();
    int[] count = new int[7];
    for(int i = 0; i < 1000000; i++) {
        int num = random.nextInt(6) + 1;
        count[num]++;
    }
    out.println("<p>随机数统计结果（共生成100万个1~6的整数）：</p>");
    out.println("<ul>");
    for(int i = 1; i <= 6; i++) {
        out.println("<li>数字 " + i + " 出现次数：" + count[i] + " 次</li>");
    }
    out.println("</ul>");
%>

<h2>输出6~100000中的全部自幕数。</h2>
<%
    out.println("<p>6~100000中的自幕数有：</p>");
    out.println("<ul>");
    int countNarcissistic = 0;
    for(int i = 6; i <= 100000; i++) {
        int digits = String.valueOf(i).length();
        int sum = 0;
        int temp = i;
        while(temp > 0) {
            int digit = temp % 10;
            int power = 1;
            for(int j = 0; j < digits; j++) {
                power *= digit;
            }
            sum += power;
            temp /= 10;
        }
        if(sum == i) {
            out.println("<li>" + i + "</li>");
            countNarcissistic++;
        }
    }
    out.println("</ul>");
    out.println("<p>共找到 " + countNarcissistic + " 个自幕数</p>");
%>
</body>
</html>