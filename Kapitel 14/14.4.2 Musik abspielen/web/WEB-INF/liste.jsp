<%@page import="java.util.List"%>
<%@page import="de.kaiguenster.javaintro.playlist.Song"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="playlist" scope="request" 
             type="de.kaiguenster.javaintro.playlist.Playlist"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meine Musik</title>
    </head>
    <body>
        <h1>Meine Musik</h1>
        <ul>
            <%
                List<Song> songs = playlist.getSongs();
                for (Song song : songs){
            %>
                <li><%=song.getTitel()%></li>
            <%}%>
        </ul>
    </body>
</html>