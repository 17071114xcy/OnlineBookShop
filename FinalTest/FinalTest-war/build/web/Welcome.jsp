<%-- 
    Document   : Welcome
    Created on : 2020-5-11, 19:32:50
    Author     : 46378
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎！</title>
    </head>
    <body>
        <form method = 'post' action="http://localhost:8080/FinalTest-war/TestServlet">
            <h1><请输入您需要查询的书籍名称></h1>
            <p><input type = "text" name = "order_book"></p>
            <p><input type = "submit" name = "Submit" value = "查询"></p>
            <p><input type="hidden" name = "Source" value = "Welcome">
        </form>
    </body>
</html>-->
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
    width:350px;
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
<form method = 'post' action="http://localhost:8080/FinalTest-war/TestServlet">
            <h1>书籍查询：</h1>
            <p>(获取全部书库请直接点击查询)</p>
            <p><input type = "text" name = "order_book"></p>
            <p><input type = "submit" name = "Submit" value = "查询"></p>
            <p><input type="hidden" name = "Source" value = "Welcome"></p>
            
        </form>
</section>

<footer>
(京)-经营性-1999-0518京公网安备12345678910JQK号京ICP证000000号
</footer>

</body>
</html>
