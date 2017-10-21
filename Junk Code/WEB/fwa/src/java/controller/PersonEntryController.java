
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

@WebServlet(name = "PersonEntryController", urlPatterns = {"/pec"})
public class PersonEntryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String personId=null,personName=null,personAddress=null;
        personId=request.getParameter("txtPersonID");
        personName=request.getParameter("txtPersonName");
        personAddress=request.getParameter("txtPersonAddress");
        //storing variables in request scope so that they are available in another page
//        request.setAttribute("personId", personId);
//        request.setAttribute("personName", personName);
//        request.setAttribute("personAddress", personAddress);
//        RequestDispatcher rd=request.getRequestDispatcher("PersonViewpage.jsp"); //URL unchanged
//        rd.forward(request, response);
        
        //Storing variables in session scope so that they are available in PersonViewpage.jsp
//        request.getSession().setAttribute("personId", personId);
//        request.getSession().setAttribute("personName", personName);
//        request.getSession().setAttribute("personAddress", personAddress);
//        response.sendRedirect("PersonViewpage.jsp"); //URL change
        
        
        //storing data as model
        Person person=new Person(personId, personName, personAddress);
        request.setAttribute("person", person);
        RequestDispatcher rd=request.getRequestDispatcher("PersonViewpage.jsp"); //URL unchanged
        rd.forward(request, response);
        
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
