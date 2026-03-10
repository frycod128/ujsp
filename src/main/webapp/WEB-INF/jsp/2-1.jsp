<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>素数查询结果</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String nStr = request.getParameter("n");
    String mStr = request.getParameter("m");

    if(name == null || name.trim().isEmpty() ||
            nStr == null || nStr.trim().isEmpty() ||
            mStr == null || mStr.trim().isEmpty()) {
        out.println("错误：请完整填写所有字段！<br>");
        return;
    }

    try {
        int n = Integer.parseInt(nStr);
        int m = Integer.parseInt(mStr);

        if(n < 2) {
            out.println("错误：n必须大于等于2！<br>");
            return;
        }

        if(m < 1) {
            out.println("错误：m必须大于等于1！<br>");
            return;
        }

        out.println("姓名：" + name + "<br>");
        out.println("从" + n + "开始的" + m + "个连续素数：<br>");

        int count = 0;
        int current = n;

        while(count < m) {
            if(isPrime(current)) {
                out.print(current);
                count++;
                if(count < m) {
                    out.print("，");
                }
                if(count % 10 == 0 && count < m) {
                    out.print("<br>");
                }
            }
            current++;
        }

    } catch(NumberFormatException e) {
        out.println("错误：请输入有效的数字！<br>");
    }
%>

</body>
</html>

<%!
    // 判断素数的函数
    private boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        if(num % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
%>