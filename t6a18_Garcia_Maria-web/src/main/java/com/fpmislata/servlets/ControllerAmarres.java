/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Amarre;
import com.fpmislata.domain.Zona;
import com.fpmislata.service.AmarreServiceLocal;
import com.fpmislata.service.ZonaServiceLocal;
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
@WebServlet(name = "ControllerAmarres", loadOnStartup = 1, 
        urlPatterns = {"/ListarAmarres", "/AltaAmarre", "/ModificarAmarre", "/EliminarAmarre", "/ListarAmarresPorZona"})
public class ControllerAmarres extends HttpServlet {

    @EJB
    private ZonaServiceLocal zonaService;

    @EJB
    private AmarreServiceLocal amarreService;

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
        
        if(userPath.equals("/ListarAmarres")){
            listarAmarres(request, response);
        }else if(userPath.equals("/AltaAmarre")){
            altaAmarre(request, response);
        }else if(userPath.equals("/ModificarAmarre")){
            modificarAmarre(request, response);
        }else if(userPath.equals("/EliminarAmarre")){
            eliminarAmarre(request, response);
        }else if(userPath.equals("ListarAmarresPorZona")){
            listarAmarresPorZona(request, response);
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

    private void listarAmarres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List listaAmarres = amarreService.listAmarres();
            
            ArrayList<Amarre> listaArrayAmarres = new ArrayList<>(listaAmarres);
            request.getSession().setAttribute("amarres", listaArrayAmarres);
            
            List listaZonas = zonaService.listZonas();
            
            ArrayList<Zona> listaArrayZonas = new ArrayList<>(listaZonas);
            request.getSession().setAttribute("zonas", listaArrayZonas);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarAmarres.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altaAmarre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        String tipo = request.getParameter("tipo");
        String dimensiones = request.getParameter("dimensiones");
        int id_zona = Integer.parseInt(request.getParameter("zona"));
        
        Amarre amarre = new Amarre(numero, tipo, dimensiones);
        
        Zona zona = new Zona();
        zona.setId(id_zona);
        zona = zonaService.findZonaById(zona);
        
        amarre.setZona(zona);
        zona.getAmarres().add(amarre);
        
        try{
            amarreService.addAmarre(amarre);
            zonaService.updateZona(zona);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        listarAmarres(request, response);
    }

    private void modificarAmarre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null && accion.equals("editar")) {
            String idAmarre = request.getParameter("id");
            
            if (idAmarre != null) {
                int id = Integer.valueOf(idAmarre);
                Amarre amarre = new Amarre();
                amarre.setId(id);
                
                try {
                    amarre = amarreService.findAmarreById(amarre);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                request.setAttribute("amarre", amarre);
                request.getRequestDispatcher("/modificarAmarre.jsp").forward(request, response);
            }
        } else if (accion != null && accion.equals("modificar")) {
            
            String id = request.getParameter("id");
            String numero = request.getParameter("numero");
            String tipo = request.getParameter("tipo");
            String dimensiones = request.getParameter("dimensiones");
            
            Amarre amarre = new Amarre();
            amarre.setId(Integer.valueOf(id));
            amarre.setNumero(Integer.valueOf(numero));
            amarre.setTipo(tipo);
            amarre.setDimensiones(dimensiones);
            
            try {
                amarreService.updateAmarre(amarre);
            } catch (Exception e) {
                e.printStackTrace();
            }

            listarAmarres(request, response);
        }
    }

    private void eliminarAmarre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Amarre amarre = new Amarre();
        amarre.setId(Integer.valueOf(id));

        try {
            amarreService.deleteAmarre(amarre);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listarAmarres(request, response);
    }

    private void listarAmarresPorZona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            
            Zona zona = new Zona();
            zona.setId(Integer.valueOf(id));
            zona = zonaService.findZonaById(zona);
            
            ArrayList<Amarre> listaArrayAmarres = new ArrayList<>(zona.getAmarres());
            request.getSession().setAttribute("amarres", listaArrayAmarres);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarAmarres.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
