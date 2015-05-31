<%-- 
    Document   : group_add
    Created on : 27.05.2015, 10:27:30
    Author     : HP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Group</title>
    </head>
    <body>
        <h1>Adding Group</h1>
        <ul>
            <c:forEach items="${groups}" var="group">
                <li>${group.groupName}</li>
            </c:forEach>
        </ul>

        <form name="TeamData" action=""  method='POST'>
            <!--<label>Группа: </label> <input name="group"  type="text" placeholder="Группа">--> 
            <input type="submit" value="Добавить">
        </form>
    </body>
</html>
