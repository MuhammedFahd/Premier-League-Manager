package menu;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    //basic attributes
    private String name;
    private String location;
    //statistic attributes
    private int wins;
    private int draws;
    private int defeats;

    //default constructor
    public SportsClub(){}

    //constructor with parameters
    public SportsClub(String name,String location){
        this.name=name;
        this.location=location;
    }

    //getters for all the attributes
    public String getName() {
        return this.name;
    }
    public String getLocation(){
        return this.location;
    }
    public int getWins() {
        return this.wins;
    }
    public int getDraws() {
        return this.draws;
    }
    public int getDefeats() {
        return this.defeats;
    }

    //setters for all the attributes
    public void setName(String name){
        this.name=name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setDraws(int draws) {
        this.draws = draws;
    }
    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }
}
