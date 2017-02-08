<%-- 
    Document   : listarEmpleados
    Created on : 03-feb-2017, 21:33:48
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Empleados</title>
    </head>
    <body>
        <h1>Listado de Empledaos</h1>
        
        <a href="agregarEmpleado.jsp">Agregar Empleado</a>
        <br/>
        <br/>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Poblacion</th>
                <th>Codigo Postal</th>
                <th>Provincia</th>
                <th></th>
                <th></th>
                <th>Visualizar Zonas</th>
            </tr>
            <%
                ArrayList<Empleado> lista = (ArrayList) session.getAttribute("empleados");
                for (Empleado empleado : lista) {
                    int id = empleado.getId();
                    String nombre = empleado.getNombre();
                    String apellidos = empleado.getApellidos();
                    String dni = empleado.getDni();
                    int telefono = empleado.getTelefono();
                    String direccion = empleado.getDireccion().getDireccion();
                    String poblacion = empleado.getDireccion().getPoblacion();
                    String codigoPostal = empleado.getDireccion().getCodigoPostal();
                    String provincia = empleado.getDireccion().getProvincia();
            %>
            <tr>
                <td><%=nombre%></td>
                <td><%=apellidos%></td>
                <td><%=dni%></td>
                <td><%=telefono%></td>
                <td><%=direccion%></td>
                <td><%=poblacion%></td>
                <td><%=codigoPostal%></td>
                <td><%=provincia%></td>
                <td><a href="ModificarEmpleado?accion=editar&id=<%=id%>">Modificar</a></td>
                <td><a href="EliminarEmpleado?id=<%=id%>">Eliminar</a></td>
                <td><a href="ListarZonasPorEmpleado?id=<%=id%>">Visualizar Zonas</a></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
