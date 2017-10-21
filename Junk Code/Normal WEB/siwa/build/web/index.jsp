<%-- 
    Document   : index
    Created on : Mar 21, 2016, 9:10:51 AM
    Author     : Rabin pc
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Goods"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Goods Entry Form</h1>
        <form action="GoodsController">
            Goods Id <input type="text" name="txtGoodsID" value="${goods.goodsId}"> <br>
            Goods Name<input type="text" name="txtGoodsName" value="${goods.goodsName}"><br>
            Goods Price<input type="text" name="txtGoodsPrice" value="${goods.goodsPrice}"><br>
            <input type="submit" value="Add" name="button"/>
            <input type="submit" value="View All" name="button"/>
            <input type="submit" value="Delete" name="button"/>
            <input type="submit" value="Update" name="button"/>
            <input type="submit" value="Find" name="button"/>
            <input type="submit" value="Query1" name="button"/>
        </form>
            ${errorMessage}
            <%
                
                if(request.getServletContext().getAttribute("goodsList")!=null)
                {
                        
                        List<Goods> goodsList=(List<Goods>)request.getServletContext().getAttribute("goodsList");
                        out.println("Total Number of elements "+goodsList.size());
                        for(Goods goods:goodsList)
                        {
                            out.println(goods+"<br>");

                        }
                }
                else
                    out.println("Empty list");
                %>
                
                  <%
                
                if(request.getServletContext().getAttribute("goodsListt")!=null)
                {
                        
                        List<Goods> goodsList=(List<Goods>)request.getServletContext().getAttribute("goodsListt");
                        out.println("Total Number of elements "+goodsList.size());
                        for(Goods goods:goodsList)
                        {
                            out.println(goods+"<br>");

                        }
                }
                else
                    out.println("Empty list");
                %>
    </body>
</html>
