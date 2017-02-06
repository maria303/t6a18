<%-- 
    Document   : agregarAmarre
    Created on : 04-feb-2017, 11:34:34
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Zona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agragar Amarre</h1>

        <form action="AltaAmarre" method="POST">
            <input type="hidden" name="accion" value="agregar"/>

            <label for="nombre">Numero:</label>
            <input type="text" name="numero" style="display: block;"/>

            <label for="nombre">Tipo:</label>
            <input type="text" name="tipo" style="display: block;"/>

            <label for="nombre">Dimensiones:</label>
            <input type="text" name="dimensiones" style="display: block;"/>

            <label for="zona">Zona:</label>
            <select name="zona" id="zona" style="display: block;">
                <%
                    List<Zona> lista = (List) session.getAttribute("zonas");
                    for (Zona zona : lista) {
                        int id = zona.getId();
                        String letra = zona.getLetra();
                %>
                <option value="<%=id%>"><%=letra%></option>
                <% }%>
            </select>
            <input type="submit" value="enviar"/>
        </form>

        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
