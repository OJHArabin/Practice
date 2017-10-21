
package controller;

import entity.Goods;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sbean.GoodsBean;

@WebServlet(name = "GoodsController", urlPatterns = {"/GoodsController"})
public class GoodsController extends HttpServlet {
@EJB
GoodsBean goodsBean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Init Executed");
         List<Goods> goodsList=goodsBean.viewAll();
         config.getServletContext().setAttribute("goodsList",goodsList);
        
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Integer goodsId=0;
        String goodsName="";
        Float goodsPrice=0f;
        String button="";
        
       
        button=request.getParameter("button");
        if(button.equalsIgnoreCase("Add"))
        {
            goodsId=Integer.parseInt(request.getParameter("txtGoodsID"));
            goodsName=request.getParameter("txtGoodsName");
            goodsPrice=Float.parseFloat(request.getParameter("txtGoodsPrice"));
            if(goodsBean.find(goodsId)==null)
            {
                 Goods goods=new Goods(goodsId, goodsName, goodsPrice);
                 goodsBean.add(goods);
                 List<Goods> goodsList=goodsBean.viewAll();
                 //request.getServletContext().setAttribute("goodsList",goodsList);
            }
            else
            {
                request.getSession().setAttribute("errorMessage", "Goods Already Exists");
            }
           
            
            response.sendRedirect("index.jsp");
        }
        else if(button.equalsIgnoreCase("find"))
        {
            goodsId=Integer.parseInt(request.getParameter("txtGoodsID"));
            Goods currentGoods=goodsBean.find(goodsId);
            request.getSession().setAttribute("goods", currentGoods);
            response.sendRedirect("index.jsp");
        }
        else if (button.equalsIgnoreCase("View ALl"))
        {
            List<Goods> goodsList=goodsBean.viewAll();
            request.getServletContext().setAttribute("goodsList", goodsList);
            response.sendRedirect("index.jsp");
        }
        else if(button.equalsIgnoreCase("Query1"))
        {
             List<Goods> goodsList=goodsBean.getGoodWithPriceMoreThan(200f);
             System.out.println("Size of list "+goodsList.size());
            request.getServletContext().setAttribute("goodsListt", goodsList);
            response.sendRedirect("index.jsp");
        }
        else if(button.equalsIgnoreCase("Update"))
        {
            goodsId=Integer.parseInt(request.getParameter("txtGoodsID"));
            //goodsId=Integer.parseInt(request.getParameter("txtGoodsID"));
            goodsName=request.getParameter("txtGoodsName");
            goodsPrice=Float.parseFloat(request.getParameter("txtGoodsPrice"));
            Goods goods=new Goods(goodsId, goodsName, goodsPrice);
            if(goodsBean.find(goodsId)!=null)
            {
                 //goodsBean.update(goods);
                goodsBean.update(goods, goodsId);
                List<Goods> goodsList=goodsBean.viewAll();
                request.getServletContext().setAttribute("goodsList", goodsList);
                
            }
            else
            {
                request.getSession().setAttribute("errorMessage", "ID doesnot exist");
            }
            response.sendRedirect("index.jsp");
        }
        else if(button.equalsIgnoreCase("Delete"))
        {
            goodsId=Integer.parseInt(request.getParameter("txtGoodsID"));
            if(goodsBean.find(goodsId)!=null)
            {
                 goodsBean.delete(goodsId);
                 List<Goods> goodsList=goodsBean.viewAll();
                 request.getServletContext().setAttribute("goodsList", goodsList);
                
            }
            else
            {
                request.getSession().setAttribute("errorMessage", "ID doesnot exist");
            }
            response.sendRedirect("index.jsp");
           
        }
        else
        {
            
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

}
