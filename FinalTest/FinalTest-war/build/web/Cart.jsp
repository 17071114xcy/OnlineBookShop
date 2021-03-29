<%-- 
    Document   : Cart
    Created on : 2020-5-12, 15:44:23
    Author     : 46378
--%>

<%@page import="bean.book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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
    <h1>当前您的购物车为：</h1>
    <% book[] books  = (book[])request.getAttribute("books");%>
        <form method = 'post' action="http://localhost:8080/FinalTest-war/TestServlet">
        <table border = '2' ALIGN=CENTER>
            <tr><td>ISBN</td><td>书名</td><td>作者</td><td>出版社</td><td>价格</td><td>数量</td><td>更改数量</tr>
            <%  int sum = 0;
                for(int i = 0 ; i < 100 ; i++){
                    if(books[i]!= null){
                        sum+=books[i].getPrice()*books[i].getNumber();
            %>
                        <tr><td><%=books[i].getISBN()%></td>
                        <td><%=books[i].getTitle()%></td>
                        <td><%=books[i].getAuther()%></td>
                        <td><%=books[i].getPress()%></td>
                        <td><%=books[i].getPrice()%></td>
                        <td><%=books[i].getNumber()%></td>
                        <td><input type = "text" name = "<%=i%>" value = <%=books[i].getNumber()%>> </td></tr>    
                        <%}
                }%>
                     
         <td>总价格：<%=sum %>元</td>                                      
        </table>
            <p><input type="hidden" name = "Source" value = "Cart">
            <p><input type = "submit" name = "Submit" value="结算"></p>
            <p><input type = "submit" name = "Submit" value="刷新"></p>
            <p><input type = "submit" name = "Submit" value="返回首页"></p>
            
        </form>
        
        
        

</section>

<footer>
(京)-经营性-1999-0518京公网安备12345678910JQK号京ICP证000000号
</footer>

</body>
</html>
