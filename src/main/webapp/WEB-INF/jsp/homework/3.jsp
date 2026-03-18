<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全局变量演示 - 网站计数器</title>
</head>
<body>
<%-- 使用JSP声明定义全局变量（属于整个JSP Servlet类） --%>
<%!
    // 这是一个全局变量，所有用户共享同一个实例
    private int visitCount = 0;

    // 可以定义一些全局方法
    public synchronized int incrementCount() {
        return ++visitCount;
    }

    public int getVisitCount() {
        return visitCount;
    }
%>

<%
    // 每次页面被访问时，增加计数
    // 注意：这里使用synchronized方法保证线程安全，因为多用户会同时访问
    int currentCount = incrementCount();
%>

<h2>全局变量演示 - 简单的网站计数器</h2>

<p>当前访问次数：<%= currentCount %></p>

<p>这个计数器使用了JSP中声明的全局变量 visitCount，</p>
<p>所有用户访问该页面时共享这个变量，因此可以统计总的访问次数。</p>
<p>刷新页面可以看到计数增加。</p>

<%-- 添加一个简单的说明，展示全局变量的作用 --%>
<h3>全局变量作用说明：</h3>
<ul>
    <li>全局变量 <strong>visitCount</strong> 是在 &lt;%! %&gt; 中声明的，属于Servlet类的成员变量。</li>
    <li>所有用户会话共享同一个visitCount变量，因此能实现跨用户的计数功能。</li>
    <li>这里使用了synchronized方法确保线程安全，避免并发访问时计数错误。</li>
    <li>如果是局部变量（在&lt;% %&gt;中声明），则每次请求都会重新初始化，无法实现计数功能。</li>
</ul>

<p>当前全局变量 visitCount 的值是：<strong><%= getVisitCount() %></strong></p>

<%
    // 演示局部变量和全局变量的区别（可选）
    int localCounter = 0;
    localCounter++;
%>
<p>对比：局部变量 localCounter 的值（每次请求重置）：<%= localCounter %></p>

</body>
</html>