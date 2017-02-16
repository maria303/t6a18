<%-- 
    Document   : modificarEmpleado
    Created on : 03-feb-2017, 23:40:54
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
        <h1>Modificar Empleado</h1>

        <form action="ModificarEmpleado?accion=modificar&id=${empleado.id}" method="post">

            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" value="${empleado.nombre}" style="display: block;" />

            <label for="email">Apellidos:</label>
            <input type="text" name="apellidos" value="${empleado.apellidos}" style="display: block;"/>

            <label for="dni">DNI:</label>
            <input type="text" name="dni" value="${empleado.dni}" style="display: block;"/>
            
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" value="${empleado.telefono}" style="display: block;"/>

            <label for="direccion">Direccion:</label>
            <input type="text" name="direccion" value="${empleado.direccion.direccion}" style="display: block;" />

            <label for="poblacion">Población:</label>
            <input type="text" name="poblacion" value="${empleado.direccion.poblacion}" style="display: block;" />

            <label for="codigoPostal">Código Postal:</label>
            <input type="text" name="codigoPostal" value="${empleado.direccion.codigoPostal}" style="display: block;" />

            <label for="provincia">Provincia:</label>
            <input type="text" name="provincia" value="${empleado.direccion.provincia}" style="display: block;" />
            
            <label for="zona">Zonas:</label>
            <br>
            <div>
            <select name="zonasRemove" size = "10" id="zonasRemove" style="display: block; float: left; width: 150px;">
                <%
                    List<Zona> lista = (List) session.getAttribute("zonas");
                    for (Zona zona : lista) {
                        int id = zona.getId();
                        String letra = zona.getLetra();
                %>
                <option value="<%=id%>"><%=letra%></option>
                <% }%>
            </select>
            <div style="float: left">
                <input type="button" id="btnAdd" value="&gt;&gt;" onclick="add()"/>
            <br>
            <input type="button" id="btnRemove" value="&lt;&lt;" onclick="remove()"/>
            </div>
            <select name="zonasAdd" size = "10" id="zonasAdd" style="display: block; width: 150px;">
            </select>
            </div>
            <br>
            
            <input type="submit" name="guardar" value="guardar">
        </form>
    </body>
</html>
