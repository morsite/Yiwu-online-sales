<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/6/1
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <%--点击链接 发送get请求，后端servlet进行处理（接收请求） doGet（）方法进行处理--%>
  <a href="MyServlet">链接</a>

  <%--表单提交访问servlet 通过action=”映射地址名称“ method 如果不写 默认get请求 doGet（） method=”post“ post请求 dupost（）
  get明文提交 不安全 数据量比较小
  post密文提交 安全 数据量比较大
  --%>
  <%--get传多个参数时不好使--%>
  <form action="RegisterServlet" method="post">
    用户名：<input type="text" name="uname"><br>
    密码：<input type="password" name="pwd"><br>
    爱好：<input type="checkbox" name="hobby" value="打球">打球
    <input type="checkbox" name="hobby" value="跳绳">跳绳
    <input type="checkbox" name="hobby" value="跑步">跑步
    <input type="submit" value="提交">
  </form>
  </body>
</html>
