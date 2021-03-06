/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Empleado;
import com.fpmislata.domain.Zona;
import com.fpmislata.service.EmpleadoServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "ControllerZonas", loadOnStartup = 1,
        urlPatterns = {"/ListarZonas", "/AltaZona", "/ModificarZona", "/EliminarZona", "/ListarZonasPorEmpleado"})
public class ControllerZonas extends HttpServlet {

    @EJB
    private EmpleadoServiceLocal empleadoService;

    @EJB
    private com.fpmislata.service.ZonaServiceLocal zonaService;

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

        if (userPath.equals("/ListarZonas")) {
            listarZonas(request, response);
        } else if (userPath.equals("/AltaZona")) {
            altaZona(request, response);
        } else if (userPath.equals("/ModificarZona")) {
            modificarZona(request, response);
        } else if (userPath.equals("/EliminarZona")) {
            eliminarZona(request, response);
        } else if (userPath.equals("/ListarZonasPorEmpleado")) {
            listarZonasPorEmpleado(request, response);
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

    private void listarZonas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List listaZonas = zonaService.listZonas();

            ArrayList<Zona> listaArrayZonas = new ArrayList<>(listaZonas);
            request.getSession().setAttribute("zonas", listaArrayZonas);

            List listaEmpleados = empleadoService.listEmpleados();
            ArrayList<Empleado> listaArrayEmpleados = new ArrayList<>(listaEmpleados);
            request.getSession().setAttribute("empleados", listaArrayEmpleados);

            RequestDispatcher rd = request.getRequestDispatcher("/listarZonas.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void altaZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String letra = request.getParameter("letra");
        int profundidad = Integer.parseInt(request.getParameter("profundidad"));
        String dimensiones = request.getParameter("dimensiones");

        String[] empleados = request.getParameterValues("empleadosAdd");

        Zona zona = new Zona();
        zona.setLetra(letra);
        zona.setProfundidad(profundidad);
        zona.setDimensiones(dimensiones);

        try {
            zonaService.addZona(zona);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (empleados != null) {
            Empleado empleado;
            for (String e : empleados) {
                empleado = new Empleado();
                int idEmpleado = Integer.parseInt(e);
                empleado.setId(idEmpleado);
                empleado = empleadoService.findEmpleadoById(empleado);
                empleado.getZonas().add(zona);
                zona.getEmpleados().add(empleado);
                try {
                    empleadoService.updateEmpleado(empleado);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        listarZonas(request, response);
    }

    private void modificarZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    private void eliminarZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Zona zona = new Zona();
        zona.setId(Integer.valueOf(id));
        zona = zonaService.findZonaById(zona);

        Set<Empleado> lista = zona.getEmpleados();
        ArrayList<Empleado> empleados = new ArrayList<>(lista);
        for (Empleado empleado : empleados) {
            empleado.getZonas().remove(zona);
            try {
                empleadoService.updateEmpleado(empleado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            zonaService.deleteZona(zona);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listarZonas(request, response);
    }

    private void listarZonasPorEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            Empleado empleado = new Empleado();
            empleado.setId(Integer.valueOf(id));
            empleado = empleadoService.findEmpleadoById(empleado);

            ArrayList<Zona> listaArrayZona = new ArrayList<>(empleado.getZonas());
            request.getSession().setAttribute("zonas", listaArrayZona);

            RequestDispatcher rd = request.getRequestDispatcher("/listarZonas.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
