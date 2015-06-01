<%-- 
    Document   : team_add
    Created on : 30.05.2015, 10:29:15
    Author     : HP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if (session.getAttribute("authorized") == null || session.getAttribute("authorized").equals("false")) {
            response.sendRedirect(request.getContextPath().concat("/admin"));
        }%>
        
        <h1>${message} ${group.getGroupName()}</h1>
        <c:if test="${groupSize>0}">Команды(${groupSize}):
            <ul>
                <c:forEach items="${teams}" var="team">
                    <li>${team.country}</li>
                </c:forEach>

            </ul>    
        </c:if>
        <c:choose>
            <c:when test="${groupSize<4}" >
                <form action="${pageContext.request.contextPath}/admin/team/add" method="POST">
                    <label>Страна:</label><input type="text" name="country" placeholder="Страна">
                    <input type="hidden" name="groupId" value="${group.getIdGroup()}">
                    <input type="submit" value="Добавить">
                </form>
            </c:when>
            <c:otherwise>
                Количество команд в группе достигло максимума
                <form action="del" method="POST">
                    <select name="team_to_del">
                        <c:forEach items="${teams}" var="team">

                            <option value="${team.idTeam}">${team.country}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Удалить команду">
                </form>
                    
            
            </c:otherwise>
        </c:choose>    
        
        
    </body>
</html>
