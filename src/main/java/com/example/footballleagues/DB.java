package com.example.footballleagues;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static String url = "jdbc:postgresql://localhost:5432/footballleague";
    private static String username = "postgres";
    private static String password = "admin";

    public static ArrayList<TeamModel> getTeams() {
        ArrayList<TeamModel> teams = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT teams.id,\n" +
                        "       teams.name,\n" +
                        "       teams.county,\n" +
                        "       teams.city,\n" +
                        "       count(m.id)                                                                                          as played,\n" +
                        "       count(case\n" +
                        "                 when (m.home_team_id = teams.id and m.home_team_goals > m.away_team_goals) or\n" +
                        "                      (m.away_team_id = teams.id and m.away_team_goals > m.home_team_goals) then teams.id end) as won,\n" +
                        "       count(case\n" +
                        "                 when (m.home_team_id = teams.id and m.home_team_goals = m.away_team_goals) or\n" +
                        "                      (m.away_team_id = teams.id and m.away_team_goals = m.home_team_goals) then teams.id end) as draw,\n" +
                        "       count(case\n" +
                        "                 when (m.home_team_id = teams.id and m.home_team_goals < m.away_team_goals) or\n" +
                        "                      (m.away_team_id = teams.id and m.away_team_goals < m.home_team_goals) then teams.id end) as lost,\n" +
                        "       sum(Case when m.home_team_id = teams.id then m.home_team_goals ELSE m.away_team_goals END)              as scored,\n" +
                        "       sum(Case when m.home_team_id = teams.id then m.away_team_goals ELSE m.home_team_goals END)              as missed,\n" +
                        "       sum(case\n" +
                        "               when (m.home_team_id = teams.id and m.home_team_goals > m.away_team_goals) or\n" +
                        "                    (m.away_team_id = teams.id and m.away_team_goals > m.home_team_goals) then 3\n" +
                        "               when (m.home_team_id = teams.id and m.home_team_goals = m.away_team_goals) or\n" +
                        "                         (m.away_team_id = teams.id and m.away_team_goals = m.home_team_goals) then 1 end) as points\n" +
                        "from teams\n" +
                        "         INNER JOIN matches m on teams.id = m.home_team_id OR teams.id = m.away_team_id\n" +
                        "group by teams.id order by points desc");

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String county = resultSet.getString("county");
                    String city = resultSet.getString("city");
                    Integer played = resultSet.getInt("played");
                    Integer won = resultSet.getInt("won");
                    Integer draw = resultSet.getInt("draw");
                    Integer lost = resultSet.getInt("lost");
                    Integer scored = resultSet.getInt("scored");
                    Integer missed = resultSet.getInt("missed");
                    Integer points = resultSet.getInt("points");

                    TeamModel team = new TeamModel(id, name, county, city, played, won, draw, lost, scored, missed, points);
                    teams.add(team);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return teams;
    }

    public static ArrayList<MatchModel> getMatches() {
        ArrayList<MatchModel> matches = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select matches.id,\n" +
                        "       matches.home_team_id,\n" +
                        "       (Select teams.name from teams WHERE matches.home_team_id = teams.id) as home_team_name,\n" +
                        "       matches.away_team_id,\n" +
                        "       (Select teams.name from teams WHERE matches.away_team_id = teams.id) as away_team_name,\n" +
                        "        matches.home_team_goals,\n" +
                        "        matches.away_team_goals\n" +
                        "from matches");
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    Long home_team = resultSet.getLong("home_team_id");
                    Long away_team = resultSet.getLong("away_team_id");
                    String home_team_name = resultSet.getString("home_team_name");
                    String away_team_name = resultSet.getString("away_team_name");
                    Integer home_team_score = resultSet.getInt("home_team_goals");
                    Integer away_team_score = resultSet.getInt("away_team_goals");

                    MatchModel team = new MatchModel(id, home_team, away_team, home_team_name, away_team_name, home_team_score, away_team_score);
                    matches.add(team);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return matches;
    }

    public static int addTeam(TeamModel newTeam) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO teams (name, county, city) Values (?, ?, ?);\n";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, newTeam.getName());
                    preparedStatement.setString(2, newTeam.getName());
                    preparedStatement.setString(3, newTeam.getCounty());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int addMatch(MatchModel newMatch) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO matches (home_team_id, away_team_id, home_team_goals, away_team_goals) VALUES (?,?,?,?);\n";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setLong(1, newMatch.getHomeTeamId());
                    preparedStatement.setLong(2, newMatch.getAwayTeamId());
                    preparedStatement.setInt(3, newMatch.getHomeTeamGoals());
                    preparedStatement.setInt(4, newMatch.getAwayTeamGoals());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
