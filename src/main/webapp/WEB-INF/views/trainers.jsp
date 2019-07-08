<%-- 
    Document   : trainers
    Created on : Jul 7, 2019, 7:10:09 PM
    Author     : giorgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainers</title>
        
        
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    </head>
    <body>
        
        <h1>Trainers List</h1>
        <a href="trainers/add">Add a new Trainer</a>
        
        <table border="1" id="trainers">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Subject</th>
                    <th>Date of birth</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "t" items="${trainers}">
                    <tr>
                        <td>${t.id}</td>
                        <td>${t.tfname}</td>
                        <td>${t.tlname}</td>
                        <td>${t.tsubject}</td>
                        <td>${t.tdob}</td>
                        <td><a href='trainers/update/${t.id}'>Update</a></td>
                        <td><a href='trainers/delete/${t.id}'>Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        
        
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>   
        <script type="text/javascript">
            $(document).ready(function() {
                $('#trainers').DataTable();
            });
        </script>
        
    </body>
</html>
