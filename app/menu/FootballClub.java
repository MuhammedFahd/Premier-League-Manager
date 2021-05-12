package menu;

import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{
    //private static final long serialVersionUID= 1L;  //used to identify the class when deserializing after serialization

    //statistic attributes
    private int noOfGoalsScored;
    private int noOfGoalsConceded;  //goals received
    private int noOfPoints;
    private int noOfMatchesPlayed;

    //default constructor
    public FootballClub(){
        super();
    }

    //constructor with parameters
    public FootballClub(String name,String location){
        super(name, location);
    }

    //setters for all the attributes
    public void setNoOfGoalsScored(int noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }
    public void setNoOfGoalsConceded(int noOfGoalsConceded) {
        this.noOfGoalsConceded = noOfGoalsConceded;
    }
    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }
    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }


    //getters for all the attributes

    public int getNoOfGoalsScored() {
        return this.noOfGoalsScored;
    }
    public int getNoOfGoalsConceded() {
        return this.noOfGoalsConceded;
    }
    public int getNoOfPoints() {
        return this.noOfPoints;
    }
    public int getNoOfMatchesPlayed() {
        return this.noOfMatchesPlayed;
    }

    //method to get the goal difference
    public int getGoalDifference(){
        return this.noOfGoalsScored-this.noOfGoalsConceded;
    }

    //overriding the compareto method to sort using the points of a club
    @Override
    public int compareTo(FootballClub footballClub) {
        if(this.noOfPoints==footballClub.getNoOfPoints()){
            if(this.getGoalDifference()<footballClub.getGoalDifference()){
                return 1;
            }else{
                return -1;
            }
        }else if(this.noOfPoints<footballClub.getNoOfPoints()){
            return 1;
        }else{
            return -1;
        }
    }

    //overriding of equals method using the name attribute of the objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FootballClub)) {
            return false;
        }
        FootballClub footballClub = (FootballClub) obj;
        return Objects.equals(this.getName(), footballClub.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
