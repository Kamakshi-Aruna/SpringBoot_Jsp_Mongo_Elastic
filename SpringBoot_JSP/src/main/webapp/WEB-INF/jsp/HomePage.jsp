<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-k6RqeWeci5ZR/Lv4MR0sA0FfDOMO6e1ZsZmbsmF5j8uQokL8K3hmg5HIp7vC3nxMtn4G9H4n1OQQZ5IlBOKSg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #4e54c8, #8f94fb);
            color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            text-align: center;
        }
        h1 {
            margin-bottom: 30px;
            font-size: 3em;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }
        .button {
            background-color: #ffffff;
            color: #333;
            border: none;
            border-radius: 8px;
            padding: 20px 40px;
            font-size: 20px;
            cursor: pointer;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s, transform 0.2s, box-shadow 0.2s;
            width: 250px;
            position: relative;
            overflow: hidden;
            z-index: 1;
        }
        .button:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 123, 255, 0.3);
            border-radius: 8px;
            z-index: -1;
            transition: opacity 0.3s;
            opacity: 0;
        }
        .button:hover {
            transform: translateY(-4px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
        }
        .button:hover:before {
            opacity: 1;
        }
        .footer {
            margin-top: 50px;
            font-size: 14px;
            color: #fff;
        }
    </style>
</head>
<body>

<h1>Welcome to Employee Management System</h1>

<div class="button-container">
    <button class="button" onclick="window.location.href='/employeeForm'"><i class="fas fa-user-plus"></i> Add Employee</button>
    <button class="button" onclick="window.location.href='/employeesList'"><i class="fas fa-list"></i> Employees List</button>
</div>

<div class="footer">
    &copy; 2024 Employee Management System
</div>

</body>
</html>
