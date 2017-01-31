/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Zona;
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
@WebServlet(name = "ControllerZonas", loadOnStartup = 1, 
        urlPatterns = {"/ListarZonas", "/AltaZona", "/ModificarZona", "/EliminarZona"})
public class ControllerZonas extends HttpServlet {

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
        
        if(userPath.equals("/ListarZonas")){
            listarZonas(request, response);
        }else if(userPath.equals("/AltaZona")){
            altaZona(request, response);
        }else if(userPath.equals("/ModificarZona")){
            modificarZona(request, response);
        }else if(userPath.equals("/EliminarZona")){
            eliminarZona(request, response);
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
        try{
            List listaZonas = zonaService.listZonas();
            
            ArrayList<Zona> listaArrayZonas = new ArrayList<>(listaZonas);
            request.getSession().setAttribute("zonas", listaArrayZonas);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarZonas.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altaZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String letra = request.getParameter("letra");
        int profundidad = Integer.parseInt(request.getParameter("profundidad"));
        String dimensiones = request.getParameter("dimensiones");
        
        Zona zona = new Zona(letra, profundidad, dimensiones);
        
        try{
            zonaService.addZona(zona);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        listarZonas(request, response);
    }

    private void modificarZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    private void eliminarZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
