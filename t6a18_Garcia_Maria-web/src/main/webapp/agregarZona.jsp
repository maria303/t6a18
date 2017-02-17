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
        <script>
            function add(){
                var idEmpleado = empleadosRemove.options[empleadosRemove.selectedIndex].value;
                var nombre = empleadosRemove.options[empleadosRemove.selectedIndex].text;
                empleadosRemove.options.remove(empleadosRemove.selectedIndex);
                var nombre2 = new Option(nombre, idEmpleado);
                empleadosAdd.options.add(nombre2);
            }
            
            function remove(){
                var idEmpleado = empleadosAdd.options[empleadosAdd.selectedIndex].value;
                var nombre = empleadosAdd.options[empleadosAdd.selectedIndex].text;
                empleadosAdd.options.remove(empleadosAdd.selectedIndex);
                var nombre2 = new Option(nombre, idEmpleado);
                empleadosRemove.options.add(nombre2);
            }
        </script>
        
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
            <%
                List<Empleado> lista = (List) session.getAttribute("empleados");
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
