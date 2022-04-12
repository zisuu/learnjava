<%@page import="de.kaiguenster.javaintro.jpa.persistence.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Neuer Kontakt</title>
    </head>
    <body>
        <h1>Neuer Kontakt</h1>
        <form method="post" action="person">
            Titel: <input type="text" name="titel"/><br/>
            Vorname: <input type="text" name="vorname" /><br/>
            Nachname: <input type="text" name="nachname" /><br/>
            <button type="submit">Speichern</button>
        </form>
    </body>
</html>
