<%-- 
    Document   : GoodsEntryForm
    Created on : Jul 1, 2015, 8:29:47 AM
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="com.cpn.demo.jta.entity.Goods"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Goods Entry From</h1>
        <form action="GoodsEntryServlet" method="post">
            <Table border="0">
                <tr><Td>Goods ID</Td><td><input type="text" name="txtGoodsID"></td></tr>
                <tr><Td>Goods Name</Td><td><input type="text" name="txtGoodsName"></td></tr>
                 <tr><Td>Goods Price</Td><td><input type="text" name="txtGoodsPrice"></td></tr>
                   <tr><Td>Goods Quantity</Td><td><input type="text" name="txtGoodsQuantity"></td></tr>
                 <tr><Td colspan="2"> <input type="submit" value="Save"></td></tr>
            </Table>
        </form>
        <%=request.getSession().getAttribute("message")%>
        
        <%
            List<Goods> goodsList=null;
            if(request.getSession().getAttribute("goodsList")!=null)
                {
                    goodsList=(List<Goods>)request.getSession().getAttribute("goodsList");
                    %>
                    <table>
                        <tr><th>Goods ID</th><th>Goods Name</th><th>Goods Price</th></tr>
                    <%
                    for(Goods goods:goodsList)
                    {
                        out.println("<tr><Td>"+goods.getGoodsID()+"</tD><td>"+goods.getGoodsName()+"</td><Td>"+goods.getGoodsPrice()+"</td></tr>");
                    }
                    out.println("</table>");
                }
            %>
                    
    </body>
</html>
