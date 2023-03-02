<%@ page import="com.example.footballleagues.MatchModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.footballleagues.TeamModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Football Leagues</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
    <div class="text-center">

        <a href="add_team.jsp"><button class="btn-secondary">Add Team</button></a>
        <a href="RecordMatchServlet"><button class="btn-secondary">Record Match</button></a>
        <hr>
        <%--Table for teams--%>
        <% ArrayList<TeamModel> teams = (ArrayList<TeamModel>) request.getAttribute("back_teams");
            for (TeamModel team : teams) {
        %>
        <header>Teams: <%=teams.size()%></header>
        <table>
            <thead>
            <tr>
                <th scope="col">ID:</th>
                <th scope="col">Name</th>
                <th scope="col">City</th>
                <th scope="col">County</th>
            </tr>
            </thead>


            <tbody>
            <tr>
                <th><%= team.getId()%>
                </th>
                <th><%= team.getName()%>
                </th>
                <th><%= team.getCity()%>
                </th>
                <th><%= team.getCounty()%>
                </th>
            </tr>
            </tbody>
            <% } %>
        </table>
        <hr>
        <%--Table for matches--%>
        <table>
            <thead>
            <tr>
                <th scope="col">ID:</th>
                <th scope="col">Home Team:</th>
                <th scope="col">Away Team:</th>
                <th scope="col">Home Team Goals:</th>
                <th scope="col">Away Team Goals:</th>

            </tr>
            </thead>

            <% ArrayList<MatchModel> matches = (ArrayList<MatchModel>) request.getAttribute("back_matches");
                for (MatchModel match : matches) {


            %>
            <tbody>
            <tr>
                <th><%= match.getId()%>
                </th>
                <th><%= match.getHomeTeamName()%>
                </th>
                <th><%= match.getAwayTeamName()%>
                </th>
                <th><%= match.getHomeTeamGoals()%>
                </th>
                <th><%= match.getAwayTeamGoals()%>
                </th>
            </tr>

            </tbody>
            <% } %>
        </table>
        <hr>
        <%--Table for league table--%>
        <table>
            <thead>
            <tr>
                <th scope="col">Place:</th>
                <th scope="col">Team</th>
                <th scope="col">Played</th>
                <th scope="col">Won</th>
                <th scope="col">Draw</th>
                <th scope="col">Lost</th>
                <th scope="col">Scored</th>
                <th scope="col">Missed</th>
                <th scope="col">Points</th>

            </tr>
            </thead>

            <%Integer place = 1;
                for (TeamModel team : teams) {
            %>
            <tbody>
            <tr>
                <th><%= place%>
                </th>
                <th><%= team.getName()%>
                </th>
                <th><%= team.getPlayedNum()%>
                </th>
                <th><%= team.getWonNum()%>
                </th>
                <th><%= team.getDrawNum()%>
                </th>
                <th><%= team.getLostNum()%>
                </th>
                <th><%= team.getGoalsNum()%>
                </th>
                <th><%= team.getMissedGoalsNum()%>
                </th>
                <th><%= team.getPointsNum() %>
                </th>

            </tr>
            </tbody>
            <%
                place++;} %>
        </table>

    </div>
</body>
</html>