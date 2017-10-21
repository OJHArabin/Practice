
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageController extends HttpServlet {

    String databaseName;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        databaseName=config.getInitParameter("databaseName");
        System.out.println("*****************************");
        System.out.println("Init Method Called");
        System.out.println("*****************************");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          System.out.println("*****************************");
        System.out.println("process request Method Called");
        System.out.println("*****************************");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MessageController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Hello World</h1>");
           Enumeration<String> headerNames= request.getHeaderNames();
           while(headerNames.hasMoreElements())
           {
               String headerName=headerNames.nextElement();
               out.println(headerName+"-->"+request.getHeader(headerName)+"<br>");
           }
            out.println("request.getContextPath()-->"+request.getContextPath()+"<br>");
            out.println("request.getQueryString()-->"+request.getQueryString()+"<br>");
            out.println("request.getRequestURI()-->"+request.getRequestURI()+"<br>");
            out.println("request.getRequestURL()-->"+request.getRequestURL()+"<br>");
             out.println("request.getParameter(\"txtMessage\")-->"+request.getParameter("txtMessage")+"<br>");
             out.println("request.getRemoteHost()-->"+request.getRemoteHost()+"<br>");
             out.println("request.getRemoteAddr()-->"+request.getRemoteAddr()+"<br>");
             out.println("Database Name is "+databaseName);
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
           System.out.println("*****************************");
        System.out.println("Destroy Method Called");
        System.out.println("*****************************");
    }

}
