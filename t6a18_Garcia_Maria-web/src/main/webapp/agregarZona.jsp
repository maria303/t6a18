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

            <label for="empleado">Empleados:</label>
            <br>
            <div>
            <select name="empleadosLeft" size = "10" id="empleadosLeft" style="display: block; float: left; width: 150px;">
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
            <div style="float: left">
            <input type="button" id="btnRight" value="&gt;&gt;"/>
            <br>
            <input type="button" id="btnLeft" value="&lt;&lt;"/>
            </div>
            <select name="empleadosRight" size = "10" id="empleadoRight" style="display: block; width: 150px;">
            </select>
            </div>
            <br>
            <input type="submit" value="enviar"/>
        </form>

        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
