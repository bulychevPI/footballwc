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
        <title>Groups</title>
    </head>
    <body>
        <h1>${message}</h1>
        <ul>
            <c:forEach items="${groups}" var="group">
                <a href="team/add/${group.idGroup}"><li>${group.groupName}</li></a>
            </c:forEach>
                
        </ul>

       
    </body>
</html>
