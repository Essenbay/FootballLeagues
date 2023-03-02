<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.02.2023
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="w-100">
<form action="AddTeamServlet" method="post" class="w-25 d-flex align-items-center justify-content-center flex-wrap">
    <div class="form-group w-100">
        <label for="teamName">Team name</label>
        <input type="text" class="form-control" id="teamName" name="frontTeamName">
    </div>
    <div class="form-group w-100">
        <label for="teamCounty">County</label>
        <input type="text" class="form-control" id="teamCounty" name="frontTeamCounty">
    </div>
    <div class="form-group w-100">
        <label for="teamCity">City</label>
        <input type="text" class="form-control" id="teamCity" name="frontTeamCity">
    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</form>
</body>
</html>
