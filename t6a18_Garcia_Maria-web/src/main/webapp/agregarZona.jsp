<%-- 
    Document   : agregarZona
    Created on : 06-feb-2017, 9:37:50
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Zona</h1>
        
        <form action="AltaEmpleado" method="POST">
            <input type="hidden" name="accion" value="agregar"/>
            
            <label for="letra">Letra:</label>
            <input type="text" name="letra" style="display: block;"/>
            
            <label for="profundidad">Profundidad:</label>
            <input type="text" name="profundidad" style="display: block;"/>
            
            <label for="dimensiones">Dimensiones:</label>
            <input type="text" name="dimensionse" style="display: block;"/>
            
            <input type="submit" value="enviar"/>
        </form>
        
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
