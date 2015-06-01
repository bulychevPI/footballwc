
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Администратор</title>
    </head>
    <body>
        <%if (session.getAttribute("authorized")== null || session.getAttribute("authorized").equals("false")){%>
        <form action="admin" method ="POST">
            <input type="text" placeholder="Логин" name = "login"/>
            <input type="text" placeholder="Пароль"name="password"/>
            <input type="submit" value ="Войти"/>
        </form>
        <%}else {%>
        <a href="${pageContext.request.contextPath}/admin/logout">Выйти</a>
        <%}%>
    </body>
</html>
