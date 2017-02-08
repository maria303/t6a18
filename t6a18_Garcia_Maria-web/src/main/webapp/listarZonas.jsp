<%-- 
    Document   : listarZonas
    Created on : 30-ene-2017, 0:57:24
    Author     : Maria
--%>

<%@page import="java.util.Set"%>
<%@page import="com.fpmislata.domain.Empleado"%>
<%@page import="com.fpmislata.domain.Zona"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de zonas</title>
    </head>
    <body>
        <h1>Listado de zonas</h1>
        
        <a href="agregarZona.jsp">Agregar zona</a>
        <br>
        <br>
        
        <table border="1">
            <tr>
                <th>Letra</th>
                <th>Profundidad</th>
                <th>Dimensiones</th>
                <th></th>
                <th></th>
                <th>Visualizar amarres</th>
                <th>Visualizar empleados</th>
            </tr>
            <% 
                ArrayList<Zona> lista = (ArrayList) session.getAttribute("zonas");
                for(Zona zona : lista){
                    int id = zona.getId();
                    String letra = zona.getLetra();
                    int profundidad = zona.getProfundidad();
                    String dimensiones = zona.getDimensiones();
            %>
            <tr>
                <td><%=letra%></td>
                <td><%=profundidad%></td>
                <td><%=dimensiones%></td>
                <!--<td>-->
                <% /*Set<Empleado> empleados = zona.getEmpleados();
                    for(Empleado empleado : empleados){
                        String empleado2 = empleado.getNombre();*/
                %>
                <%/*=empleado2 + " "*/%>
                <%/* }*/ %>
                <!--</td>-->
                <td><a href="ModificarZona?accion=editar&id=<%=id%>">Modificar zona</a></td>
                <td><a href="EliminarZona?id=<%=id%>">Eliminar zona</a></td>
                <td><a href="ListarAmarresPorZona?id=<%=id%>">Visualizar amarres</a></td>
                <td><a href="ListarEmpleadosPorZona?id=<%=id%>">Visualizar empleados</a></td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
