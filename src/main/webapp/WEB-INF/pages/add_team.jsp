<%-- 
    Document   : addTeam
    Created on : 26.05.2015, 12:00:02
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddTeam</title>
    </head>
    <body>
        <h1>Adding Team</h1>
        <form name="TeamData" action="add" method='POST'>
            <label>Страна: </label> <input name="country" type="text" palceholder="Страна"> 
            <input type="submit" value="Добавить">
        </form>
    </body>
</html>
