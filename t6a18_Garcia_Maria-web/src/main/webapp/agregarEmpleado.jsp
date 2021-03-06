<%-- 
    Document   : agregarEmpleado
    Created on : 03-feb-2017, 23:36:26
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
        
        <h1>Agregar Empleado</h1>
        
        <form action="AltaEmpleado" method="POST">
            <input type="hidden" name="accion" value="agregar"/>
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;"/>
            
            <label for="apellidos">Apellidos:</label>
            <input type="text" name="apellidos" style="display: block;"/>
            
            <label for="dni">DNI:</label>
            <input type="text" name="dni" style="display: block;"/>
            
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" style="display: block;"/>
            
            <label for="direccion">Direccion:</label>
            <input type="text" name="direccion" style="display: block;" />
            
            <label for="poblacion">Población:</label>
            <input type="text" name="poblacion" style="display: block;" />
            
            <label for="codigoPostal">Código Postal:</label>
            <input type="text" name="codigoPostal" style="display: block;" />
            
            <label for="provincia">Provincia:</label>
            <input type="text" name="provincia" style="display: block;" />
            
            <label for="zona">Zonas:</label>
            <br>
            <div>
                <%
                    List<Zona> lista = (List) session.getAttribute("zonas");
                    for (Zona zona : lista) {
                        int id = zona.getId();
                        String letra = zona.getLetra();
                %>
                <input type="checkbox" name="zonasAdd" value="<%=id%>"><%=letra%>
                <% }%>
            </div>
            <br>
            
            <input type="submit" value="enviar"/>
        </form>
        
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
