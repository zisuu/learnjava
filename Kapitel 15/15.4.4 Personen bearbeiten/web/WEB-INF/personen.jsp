<%@page import="de.kaiguenster.javaintro.jpa.persistence.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personen" scope="request" type="java.util.List<de.kaiguenster.javaintro.jpa.persistence.Person>"/>
<jsp:useBean id="query" scope="request" type="java.lang.String"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontakte</title>
    </head>
    <body>
        <h1>Ihre Kontakte</h1>
        <form action="personen" method="get">
            <input type="text" name="query" value="<%=query%>">
            <button type="submit">Suche</button>
        </form>
        <a href="person">Neuer Kontakt</a>
        <ul>
            <%for (Person p : personen){%>
            <li>
                <%--Für jede Person wird ein Bearbeiten-Link erzeugt. Die ID wird als URL-Parameter übergeben. --%>
                <a href="person?id=<%=p.getId()%>"><%=p.getVorname()%> <%=p.getNachname()%></a>
            </li>
            <%}%>
        </ul>
    </body>
</html>
