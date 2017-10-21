/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpn.demo.jta.controller;

import com.cpn.demo.jta.entity.Goods;
import com.cpn.demo.jta.entity.Stock;
import com.cpn.demo.jta.slsb.GoodsFacade;
import com.cpn.demo.jta.slsb.StockFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "GoodsEntryServlet", urlPatterns = {"/GoodsEntryServlet"})
public class GoodsEntryServlet extends HttpServlet {
    @EJB
    GoodsFacade goodsFacade;
    @EJB
    StockFacade stockFacade;
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
      int goodsID=0,goodsPrice=0,goodsQuantity=0;
        String goodsName="";
        
        if(request.getParameter("txtGoodsID")!=null)
            goodsID=Integer.parseInt(request.getParameter("txtGoodsID"));
        if(request.getParameter("txtGoodsPrice")!=null)
            goodsPrice=Integer.parseInt(request.getParameter("txtGoodsPrice"));
            goodsName=request.getParameter("txtGoodsName");
        if(request.getParameter("txtGoodsQuantity")!=null)
            goodsQuantity=Integer.parseInt(request.getParameter("txtGoodsQuantity"));
        
            Goods goods=new Goods(goodsID, goodsName, goodsPrice);
          //  Stock stock=new Stock(goodsID, goodsQuantity);
            
          //  goodsFacade.create(goods);
          //  stockFacade.create(stock);
           String result= goodsFacade.storeGoodsStock(goods, goodsQuantity);
           request.getSession().setAttribute("message", result);
                
            
            List<Goods> goodsList=new LinkedList<>();
            goodsList=goodsFacade.findAll();
            request.getSession().setAttribute("goodsList", goodsList);
            response.sendRedirect("GoodsEntryForm.jsp");
            
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

}
