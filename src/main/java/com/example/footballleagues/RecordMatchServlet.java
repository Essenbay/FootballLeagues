package com.example.footballleagues;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecordMatchServlet", value = "/RecordMatchServlet")
public class RecordMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TeamModel> teams = DB.getTeams();
        request.setAttribute("back_teams", teams);
        request.getRequestDispatcher("/record_match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long homeTeam = Long.parseLong(request.getParameter("frontHomeTeam"));
        Integer homeTeamGoals = Integer.parseInt(request.getParameter("frontHomeTeamGoals"));
        Long awayTeam = Long.parseLong(request.getParameter("frontAwayTeam"));
        Integer awayTeamGoals = Integer.parseInt(request.getParameter("frontAwayTeamGoals"));
        if(homeTeam.equals(awayTeam)) {
            String message = "Teams must not be same";
            request.setAttribute("back_message", message);
            ArrayList<TeamModel> teams = DB.getTeams();
            request.setAttribute("back_teams", teams);
            request.getRequestDispatcher("/record_match.jsp").forward(request, response);
        }
        else {
            MatchModel newMatch = new MatchModel(homeTeam, awayTeam, homeTeamGoals, awayTeamGoals);
            DB.addMatch(newMatch);
            response.sendRedirect("MainPageServlet");
        }
    }
}
