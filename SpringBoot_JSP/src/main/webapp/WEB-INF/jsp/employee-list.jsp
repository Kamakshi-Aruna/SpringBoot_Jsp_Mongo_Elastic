<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.5.2/css/bootstrap-theme.min.css" rel="stylesheet">
    <script>
        function confirmDeleteAll() {
            return confirm('Are you sure you want to delete all employees? This action cannot be undone.');
        }
    </script>
</head>
<body>
<div class="container">
    <h2 class="mt-4">Employees Details</h2>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Department</th>
            <th scope="col" class="text-center">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty employeesMongo}">
            <c:forEach items="${employeesMongo}" var="employee">
                <tr>
                    <td>${employee.id != null ? employee.id : 'N/A'}</td>
                    <td>${employee.name != null ? employee.name : 'N/A'}</td>
                    <td>${employee.department != null ? employee.department : 'N/A'}</td>
                    <td class="text-center">
                        <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/update/${employee.id}">Edit</a>
                        <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/delete/${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty employeesMongo}">
            <tr>
                <td colspan="4" class="text-center">No employees found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <a class="btn btn-success" href="employeeForm">Create New Employee</a>
    <a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteAll" onclick="return confirmDeleteAll();">Delete All</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
