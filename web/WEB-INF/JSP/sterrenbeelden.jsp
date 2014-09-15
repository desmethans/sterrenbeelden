<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Sterrenbeelden</title>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css" />
    </head>
    <body>
        <form action="<c:url value='/'/>" method="get">
            <div>
                <label>Geboortedatum:
                    <input name="datum" value="${param.datum}" autofocus/>
                </label>
                <input type="submit" value="Sterrenbeeld"/>
                ${fout}
            </div>
        </form>
        <c:if test="${not empty beeld}">
            <div>
                <img src= "${pageContext.servletContext.contextPath}/images/${beeld}.png" alt="${beeld}" />
            </div>
            <div>
                 <span class="${beeld}">Je sterrenbeeld: ${beeld}</span>
            </div>
        </c:if>
    </body>
</html>
