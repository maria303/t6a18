<%-- 
    Document   : agregarZona
    Created on : 06-feb-2017, 9:37:50
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Zona</h1>
        
        <form action="AltaZona" method="POST">
            <input type="hidden" name="accion" value="agregar"/>
            
            <label for="letra">Letra:</label>
            <input type="text" name="letra" style="display: block;"/>
            
            <label for="profundidad">Profundidad:</label>
            <input type="text" name="profundidad" style="display: block;"/>
            
            <label for="dimensiones">Dimensiones:</label>
            <input type="text" name="dimensiones" style="display: block;"/>
            
            <label for="empleado">Empleado:</label>
            <select name="empleado" id="empleado" style="display: block;">
                <%
                    List<Empleado> lista = (List) session.getAttribute("empleados");
                    for (Empleado empleado : lista) {
                        int id = empleado.getId();
                        String nombre = empleado.getNombre();
                        String apellidos = empleado.getApellidos();
                %>
                <option value="<%=id%>"><%=nombre%> - <%=apellidos%></option>
                <% }%>
            </select>
            <input type="submit" value="enviar"/>
        </form>
        
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
