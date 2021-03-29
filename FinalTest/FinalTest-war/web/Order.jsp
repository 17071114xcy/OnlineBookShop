<%-- 
    Document   : Order
    Created on : 2020-5-12, 22:30:41
    Author     : 46378
--%>

<%@page import="bean.book"%>
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
     <%  int i;
            int sum2 = 0;
            book[] books  = (book[])request.getAttribute("books");
            int sum = 0;
                for(i = 0 ; i < 100 ; i++){
                    if(books[i]!= null){
                        sum+=books[i].getPrice()*books[i].getNumber();
                        sum2+=books[i].getNumber();
                    }
                    else break;
                }
        %>
        <p>尊敬的客户您好，本次您共选购了<%=sum2%>本书，共计<%=sum%>元，请提供您的收货地址：</p>
        <button onclick="myFunction()">收货地址：</button>
<p id="demo"></p>
<script>
function myFunction() {
  var txt;
  var person = prompt("请输入您的地址：", "北京");
  if (person == null || person == "") {
    txt = "用户取消输入";
  } else {
    txt = "您输入的地址为" + person + "，您选购的图书正在飞快地向您奔去！";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>

</section>

<footer>
(京)-经营性-1999-0518京公网安备12345678910JQK号京ICP证000000号
</footer>

</body>
</html>