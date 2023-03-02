package com.example.footballleagues;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddTeamServlet", value = "/AddTeamServlet")
public class AddTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("frontTeamName");
        String county = request.getParameter("frontTeamCounty");
        String city = request.getParameter("frontTeamCity");

        TeamModel newTeam = new TeamModel(name, county, city);
        DB.addTeam(newTeam);
        response.sendRedirect("MainPageServlet");
    }
}
