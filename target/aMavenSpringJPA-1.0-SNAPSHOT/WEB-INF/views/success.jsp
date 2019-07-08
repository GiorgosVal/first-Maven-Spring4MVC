<%-- 
    Document   : success
    Created on : Jul 7, 2019, 9:00:43 PM
    Author     : giorgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${success}</h1>
        
        
        <% 
            response.setHeader("Refresh", String.valueOf(request.getAttribute("path")));
        %>
    </body>
</html>
