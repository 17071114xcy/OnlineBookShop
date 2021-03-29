<!--
    Document   : Directory
    Created on : 2020-5-11, 19:36:17
    Author     : 46378
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
header {
    background-color:white;
    color:blue;
    text-align:center;
    padding:5px;	 
}
nav {
    line-height:30px;
    background-color:white;
    color:black;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
section {
    width:1000px;
    float:left;
    padding:10px;	 	 
}
footer {
    background-color:white;
    color:black;
    clear:both;
    text-align:center;
    padding:5px;	 	 
}
</style>
</head>

<body>

<header>
<h1>聪聪的书店</h1>
</header>

<nav>

小说<br>
文学<br>
青春文学<br>
艺术<br>
经济与管理<br>
金融与投资<br>
育儿/家教<br>
历史<br>
心理学<br>
(点不了)<br>
</nav>

<section>
    <h1>查询结果如下所示：请在感兴趣的图书的选择栏打勾（✔）</h1>
<%java.util.List<entity.Book> Found_books = (java.util.List<entity.Book>)request.getAttribute("result");%>
         <form method = 'post' action="http://localhost:8080/FinalTest-war/TestServlet">
         <%java.util.Iterator<entity.Book> it = Found_books.iterator();%>
        <table border = '2' ALIGN=CENTER>
            <tr><td>ISBN</td><td>书名</td><td>作者</td><td>出版社</td><td>价格</td><td>选择</td></tr>
                <%
                while(it.hasNext()){
                    entity.Book au = it.next();%>
                    <tr><td><%=au.getIsbn()%></td>
                    <td><%=au.getTitle()%></td>
                    <td><%=au.getAuther()%></td>
                    <td><%=au.getPress()%></td>
                    <td><%=au.getPrice()%></td>
                    <td><input type="checkbox" name='choose' value=<%=au.getIsbn()%>></td></tr>                                          
        <%}%>
            </table>
            <p><input type="hidden" name = "Source" value = "Directory">
            <p><input type = "submit" name = "Submit" value="加入购物车"></p>
            <p><input type = "submit" name = "Submit" value="返回首页"></p>
        </form>
</section>

<footer>
(京)-经营性-1999-0518京公网安备12345678910JQK号京ICP证000000号
</footer>

</body>
</html>
