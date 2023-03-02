package com.example.footballleagues;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainPageServlet", value = "/MainPageServlet")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TeamModel> teams = DB.getTeams();
        request.setAttribute("back_teams", teams);

        ArrayList<MatchModel> matches = DB.getMatches();
        request.setAttribute("back_matches", matches);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
