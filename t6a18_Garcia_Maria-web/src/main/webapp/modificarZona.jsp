<%-- 
    Document   : modificarZona
    Created on : 16-feb-2017, 9:47:38
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
        <h1>Modificar Zona</h1>

        <form action="ModificarZona?accion=modificar&id=${zona.id}" method="post">
            <input type="hidden" name="accion" value="agregar"/>

            <label for="letra">Letra:</label>
            <input type="text" name="letra" value="${zona.letra}" style="display: block;"/>

            <label for="profundidad">Profundidad:</label>
            <input type="text" name="profundidad" value="${zona.profundidad}" style="display: block;"/>

            <label for="dimensiones">Dimensiones:</label>
            <input type="text" name="dimensiones" value="${zona.dimensiones}" style="display: block;"/>

            <label for="empleado">Empleados:</label>
            <br>
            <%
                List<Empleado> lista = (List) request.getAttribute("empleados");
                for (Empleado empleado : lista) {
                    int id = empleado.getId();
                    String nombre = empleado.getNombre();
            %>
            <input type="checkbox" name="empleadosAdd" value="<%=id%>"><%=nombre%>
            <% }%>
            <br>
            
            <input type="submit" value="enviar"/>
        </form>

        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
