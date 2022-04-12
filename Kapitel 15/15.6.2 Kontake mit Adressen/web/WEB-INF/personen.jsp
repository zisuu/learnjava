<%@page import="de.kaiguenster.javaintro.jpa.persistence.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personen" scope="request" type="java.util.List<de.kaiguenster.javaintro.jpa.persistence.Person>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontakte</title>
    </head>
    <body>
        <h1>Ihre Kontakte</h1>
        <form action="personen" method="get">
            Name: <input type="text" name="query">
            <button type="submit">Suche</button>
        </form>
        <form action="personen" method="get">
            Ort: <input type="text" name="ort">
            <button type="submit">Suche</button>
        </form>
        <a href="person">Neuer Kontakt</a>
        <ul>
            <%for (Person p : personen){%>
            <li>
                <a href="person?id=<%=p.getId()%>"><%=p.getVorname()%> <%=p.getNachname()%></a>
            </li>
            <%}%>
        </ul>
    </body>
</html>
