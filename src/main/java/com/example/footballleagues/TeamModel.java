package com.example.footballleagues;

public class TeamModel {
    private Long id;
    private String name;
    private String county;
    private String city;
    private Integer playedNum = 0;

    private Integer wonNum = 0;
    private Integer drawNum = 0;
    private Integer lostNum = 0;
    private Integer goalsNum = 0;
    private Integer missedGoalsNum = 0;
    private Integer pointsNum = 0;

    public TeamModel() {
    }

    public TeamModel(String name, String county, String city) {
        this.name = name;
        this.county = county;
        this.city = city;
    }

    public TeamModel(Long id, String name, String county, String city) {
        this.id = id;
        this.name = name;
        this.county = county;
        this.city = city;
    }

    public TeamModel(Long id, String name, String county, String city, Integer playedNum, Integer wonNum, Integer drawNum, Integer lostNum, Integer goalsNum, Integer missedGoalsNum, Integer pointsNum) {
        this.id = id;
        this.name = name;
        this.county = county;
        this.city = city;
        this.playedNum = playedNum;
        this.wonNum = wonNum;
        this.drawNum = drawNum;
        this.lostNum = lostNum;
        this.goalsNum = goalsNum;
        this.missedGoalsNum = missedGoalsNum;
        this.pointsNum = pointsNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPlayedNum() {
        return playedNum;
    }

    public Integer getWonNum() {
        return wonNum;
    }

    public Integer getDrawNum() {
        return drawNum;
    }

    public Integer getLostNum() {
        return lostNum;
    }

    public Integer getGoalsNum() {
        return goalsNum;
    }

    public Integer getMissedGoalsNum() {
        return missedGoalsNum;
    }

    public Integer getPointsNum() {
        return pointsNum;
    }
}
