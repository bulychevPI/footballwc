<%-- 
    Document   : team_add
    Created on : 30.05.2015, 10:29:15
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${message} ${group.getGroupName()}</h1>
        <form action="${pageContext.request.contextPath}/admin/team/add" method="POST">
            <label>Страна:</label><input type="text" name="country" placeholder="Страна">
            <input type="hidden" name="groupId" value="${group.getIdGroup()}">
            <input type="submit" value="Добавить">
        </form>
    </body>
</html>
