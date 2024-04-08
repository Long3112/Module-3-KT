<%--
  Created by IntelliJ IDEA.
  User: thats
  Date: 4/7/2024
  Time: 12:29 PM
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
</head>
<body>
<form method="post" action="http://localhost:8080/employees?action=edit">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Name</label>
      <input type="text" class="form-control" id="inputEmail4" name="name" value="${employeeEdit.name}">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Phone</label>
      <input type="text" class="form-control" id="inputPassword4" name="phone" value="${employeeEdit.phone}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address" value="${employeeEdit.address}">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Email</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" name="email" value="${employeeEdit.email}">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Salary</label>
      <input type="text" class="form-control" id="inputCity" name="salary" value="${employeeEdit.salary}">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">Department</label>
      <select id="inputState" class="form-control" name="idCategory">
        <c:forEach items="${list}" var="category">
          <option value="${category.id}">${category.name}</option>
        </c:forEach>
      </select>
    </div>

  </div>
  <div class="form-group">
    <div class="form-check">
      <button type="submit" class="btn btn-primary">Ok</button>
      </label>
    </div>
  </div>
</form>

</body>
</html>
