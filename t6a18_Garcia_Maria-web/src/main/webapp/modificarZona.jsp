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
            <div>
            <select name="empleadosRemove" size = "10" id="empleadosRemove" style="display: block; float: left; width: 150px;">
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
                <input type="button" id="btnAdd" value="&gt;&gt;" onclick="add()"/>
            <br>
            <input type="button" id="btnRemove" value="&lt;&lt;" onclick="remove()"/>
            </div>
            <select name="empleadosAdd" size = "10" id="empleadosAdd" style="display: block; width: 150px;">
            </select>
            </div>
            <br>
            
            <input type="submit" value="enviar"/>
        </form>

        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
