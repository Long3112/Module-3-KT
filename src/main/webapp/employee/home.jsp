<%--
  Created by IntelliJ IDEA.
  User: thats
  Date: 4/5/2024
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <title>Basic Form</title>
    <link href="../css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
<td><button type="button" class="btn btn-primary" href =" http://localhost:8080/employees?action=create">Them moi</button></td>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Salary</th>
        <th scope="col">Department</th>
        <th scope="col " colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${employees}" var="employee">
        <th scope="row">1</th>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.phone}</td>
        <td>${employee.salary}</td>
        <td>${employee.department.name}</td>
        <td><button type="button" class="btn btn-primary"  href="http://localhost:8080/staff?action=edit=${employees.id}">Sua</button></td>
        <td><button type="button" class="btn btn-primary" onclick="deleteEmployee(${employees.id})">Xoa</button></td>
        </c:forEach>



    </tr>

    </tbody>
</table>
<script>
    function deleteStaff(id){
        let isConfirm = confirm("Are you sure you want to delete")
        if (isConfirm){
            window.location.href = "http://localhost:8080/employee?action=delete="+id
        }
    }
</script>
</body>
</html>