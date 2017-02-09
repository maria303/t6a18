<%-- 
    Document   : modificarAmarre
    Created on : 04-feb-2017, 11:45:05
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
        <h1>Modificar Amarre</h1>
        
        <form action="ModificarAmarre?accion=modificar&id=${amarre.id}" method="post">
            <input type="hidden" name="accion" value="agregar"/>

            <label for="numero">Numero:</label>
            <input type="text" name="numero" value="${amarre.numero}" style="display: block;"/>

            <label for="tipo">Tipo:</label>
            <input type="text" name="tipo" value="${amarre.tipo}" style="display: block;"/>

            <label for="dimensiones">Dimensiones:</label>
            <input type="text" name="dimensiones" value="${amarre.dimensiones}" style="display: block;"/>
            
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
