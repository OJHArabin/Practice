<%-- 
    Document   : PersonViewpage
    Created on : Feb 10, 2016, 8:32:13 AM
    Author     : user
--%>

<%@page import="model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Person Detail</h1>
<%--        Person Id is <%=request.getAttribute("personId")%> <br>
        Person Name is <%=request.getAttribute("personName")%> <br>
        Person Address is <%=request.getAttribute("personAddress")%> <br> --%>

    <%      
        Person person= (Person)request.getAttribute("person");     
    %>
    <div style="background-color: brown">
        Person Id is <% out.println(person.getId()); %> <br>
        Person Name is <% out.println(person.getName()); %>  <br>
        Person Address is <% out.println(person.getAddress()); %> <br> 
    </div>
        
    </body>
</html>
