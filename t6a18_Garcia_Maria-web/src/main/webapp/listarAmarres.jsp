<%-- 
    Document   : listarAmarres
    Created on : 30-ene-2017, 1:20:52
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Amarre"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de amarres</title>
    </head>
    <body>
        <h1>Listado de amarres</h1>
        
        <a href="agregarAmarre.jsp">Agragar amarre</a>
        <br>
        <br>
        
        <table border="1">
            <tr>
                <th>Numero</th>
                <th>Tipo</th>
                <th>Dimensiones</th>
                <th>Zona</th>
                <th></th>
                <th></th>
            </tr>
            <% 
                ArrayList<Amarre> lista = (ArrayList) session.getAttribute("amarres");
                for(Amarre amarre : lista){
                    int id = amarre.getId();
                    int numero = amarre.getNumero();
                    String tipo = amarre.getTipo();
                    String dimensiones = amarre.getDimensiones();
                    String zona = amarre.getZona().getLetra();
            %>
            <tr>
                <td><%=numero%></td>
                <td><%=tipo%></td>
                <td><%=dimensiones%></td>
                <td><%=zona%></td>
                <td></td>
                <td></td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
