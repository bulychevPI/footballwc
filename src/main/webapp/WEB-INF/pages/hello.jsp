<%-- 
    Document   : hello
    Created on : 24.05.2015, 12:21:09
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--        <link rel="stylesheet" href="../../resources/css/team.css" >-->
        <style>
            <%@include file='../resources/css/team.css' %>
        </style>  
    </head>
    <body>
        <h1>Hello Yeeeah!  ${message}</h1>
        <a href="/bob">bob</a>
    </body>
</html>
