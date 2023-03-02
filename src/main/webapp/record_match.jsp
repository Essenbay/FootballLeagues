<%@ page import="com.example.footballleagues.TeamModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.02.2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="RecordMatchServlet" method="post" class="w-25 d-flex align-items-center justify-content-center flex-wrap">
    <%ArrayList<TeamModel> teams = (ArrayList<TeamModel>) request.getAttribute("back_teams");
        String message = (String) request.getAttribute("back_message");
        if (message != null) {
    %>
    <header class="w-100">
    <%=message%></header>
    <%
        }
    %>    <div class="form-group w-100">
        <label for="homeTeam">Select a home team</label>
        <select class="form-select" aria-label="Default select example" id="homeTeam" name="frontHomeTeam">
            <option selected>Select home team</option>
            <% for (TeamModel team : teams) {
            %>
            <option value="<%=team.getId()%>"><%=team.getName()%></option>
            <% } %>
        </select>
    </div>
    <div class="form-group w-100">
        <label for="homeTeam">Home team goals</label>
        <input type="number" class="form-control" id="homeTeamGoals" name="frontHomeTeamGoals">
    </div>

    <div class="form-group w-100">
        <label for="awayTeam">Select an away team</label>
        <select class="form-select" aria-label="Default select example" id="awayTeam" name="frontAwayTeam">
            <option selected>Select home team</option>
            <% for (TeamModel team : teams) {
            %>
            <option value="<%=team.getId()%>"><%=team.getName()%></option>
            <% } %>
        </select>
    </div>
    <div class="form-group w-100">
        <label for="awayTeamGoals">Away team goals</label>
        <input type="number" class="form-control" id="awayTeamGoals" name="frontAwayTeamGoals">
    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</form>

</body>
</html>
