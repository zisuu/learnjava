<%@page import="de.kaiguenster.javaintro.jpa.persistence.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="person" scope="request" class="de.kaiguenster.javaintro.jpa.persistence.Person"/>
<!DOCTYPE html>
<%
    String titel;
    if (person.getId() != null){
        titel = person.getVorname() + " " + person.getNachname();
    } else {
        titel = "Neuer Kontakt";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titel%></title>
    </head>
    <body>
        <h1><%=titel%></h1>
        <form method="post" action="person">
            <%if (person.getId() != null){%>
                <input type="hidden" name="id" value="<%=person.getId()%>"/>
            <%}%>
            Titel: <input type="text" name="titel" value="<%=person.getTitel()%>"/><br/>
            Vorname: <input type="text" name="vorname" value="<%=person.getVorname()%>"/><br/>
            Nachname: <input type="text" name="nachname" value="<%=person.getNachname()%>"/><br/>
            Strasse: <input type="text" name="strasse" value="<%=person.getAdresse().getStrasse()%>"/> Nr: <input type="text" name="hausnr" length="5" value="<%=person.getAdresse().getHausnummer()%>"/><br/>
            PLZ: <input type="text" name="plz" length="5" value="<%=person.getAdresse().getPlz()%>"/> Ort: <input type="text" name="ort" value="<%=person.getAdresse().getOrt()%>"/><br/>
            <button type="submit">Speichern</button>
        </form>
    </body>
</html>
