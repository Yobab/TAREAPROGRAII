/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.BaseDatos;

/**
 *
 * @author Arachely
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Servlet extends HttpServlet {
    BaseDatos BD = new BaseDatos();
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getParameter("caso")){
            case "OpcionesMarca": response.getWriter().write(BD.OpcionesMarcas().toString());break;
            case "OpcionesCategoria": response.getWriter().write(BD.OpcionesCategorias().toString());break;
            case "Marcas": response.getWriter().write(BD.obtenerMarcas().toString());break;
            case "Categorias": response.getWriter().write(BD.obtenerCategorias().toString());break;
            case "Productos": response.getWriter().write(BD.obtenerProductos().toString());break;
        }
        
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
            switch(request.getParameter("caso")){
                case "Marca": BD.registrarMarca(request.getParameter("nombre"),request.getParameter("descripcion"));  break;
                case "Categoria": BD.registrarCategoria(request.getParameter("nombre"),request.getParameter("descripcion"));  break;
                case "Producto": BD.registrarProducto(request.getParameter("codigo"),
                        request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("precio")),
                        Integer.parseInt(request.getParameter("marca")), Integer.parseInt(request.getParameter("categoria")));break;
            }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
