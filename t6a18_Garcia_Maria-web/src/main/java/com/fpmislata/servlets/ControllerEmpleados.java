/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Direccion;
import com.fpmislata.domain.Empleado;
import com.fpmislata.service.EmpleadoServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
@WebServlet(name = "ControllerEmpleados", loadOnStartup = 1, 
        urlPatterns = {"/ListarEmpleados", "/AltaEmpleado", "/ModificarEmpleado", "/EliminarEmpleado"})
public class ControllerEmpleados extends HttpServlet {

    @EJB
    private EmpleadoServiceLocal empleadoService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String userPath = request.getServletPath();
        
        if(userPath.equals("/ListarEmpleados")){
            listarEmpleados(request, response);
        }else if(userPath.equals("/AltaEmpleado")){
            altaEmpleado(request, response);
        }else if(userPath.equals("/ModificarEmpleado")){
            ModificarEmpleado(request, response);
        }else if(userPath.equals("/EliminarEmpleado")){
            eliminarEmpleado(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List listaEmpleados = empleadoService.listEmpleados();
            
            ArrayList<Empleado> listaArrayEmpleados = new ArrayList<>(listaEmpleados);
            request.getSession().setAttribute("empleados", listaArrayEmpleados);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarEmpleados.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altaEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        int telefono = Integer.valueOf(request.getParameter("telefono"));
        String direccion = request.getParameter("direccion");
        String poblacion = request.getParameter("poblacion");
        String codigoPostal = request.getParameter("codigoPostal");
        String provincia = request.getParameter("provincia");
        
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellidos(apellidos);
        empleado.setDni(dni);
        empleado.setTelefono(telefono);
        
        Direccion d = new Direccion();
        d.setDireccion(direccion);
        d.setPoblacion(poblacion);
        d.setCodigoPostal(codigoPostal);
        d.setProvincia(provincia);
        empleado.setDireccion(d);
        
        try {
            empleadoService.addEmpleado(empleado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        listarEmpleados(request, response);
    }

    private void ModificarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null && accion.equals("editar")) {
            String idEmpleado = request.getParameter("id");
            
            if (idEmpleado != null) {
                int id = Integer.valueOf(idEmpleado);
                Empleado empleado = new Empleado();
                empleado.setId(id);
                
                try {
                    empleado = this.empleadoService.findEmpleadoById(empleado);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                request.setAttribute("empleado", empleado);
                request.getRequestDispatcher("/modificarEmpleado.jsp").forward(request, response);
            }
        } else if (accion != null && accion.equals("modificar")) {
            
            String idEmpleado = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String poblacion = request.getParameter("poblacion");
            String codigoPostal = request.getParameter("codigoPostal");
            String provincia = request.getParameter("provincia");
            
            Empleado empleado = new Empleado();
            int id = Integer.valueOf(idEmpleado);
            empleado.setId(id);
            empleado.setNombre(nombre);
            empleado.setApellidos(apellidos);
            empleado.setDni(dni);
            empleado.setTelefono(Integer.valueOf(telefono));
            
            
            Direccion d = new Direccion();
            d.setDireccion(direccion);
            d.setPoblacion(poblacion);
            d.setCodigoPostal(codigoPostal);
            d.setProvincia(provincia);
            empleado.setDireccion(d);
            
            try {
                this.empleadoService.updateEmpleado(empleado);
            } catch (Exception e) {
                e.printStackTrace();
            }

            listarEmpleados(request, response);
        }
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String idEmpleado = request.getParameter("id");

        int id = Integer.parseInt(idEmpleado);
        Empleado empleado = new Empleado();
        empleado.setId(id);

        try {
            this.empleadoService.deleteEmpleado(empleado);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listarEmpleados(request, response);
    }

}
