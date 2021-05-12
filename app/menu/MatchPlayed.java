package menu;

import java.io.Serializable;
import java.util.Objects;

public class MatchPlayed implements Serializable {
    private FootballClub homeTeam;
    private FootballClub awayTeam;
    private int noOfGoalsScoredByHomeTeam;
    private int noOfGoalsScoredByAwayTeam;
    private Date matchPlayedDate;   //user defined Date class has been used

    public MatchPlayed(){}

    public MatchPlayed(FootballClub homeTeam, FootballClub awayTeam, int noOfGoalsScoredByHomeTeam, int noOfGoalsScoredByAwayTeam, Date matchPlayedDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.noOfGoalsScoredByHomeTeam = noOfGoalsScoredByHomeTeam;
        this.noOfGoalsScoredByAwayTeam = noOfGoalsScoredByAwayTeam;
        this.matchPlayedDate = matchPlayedDate;
    }

    public FootballClub getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(FootballClub homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballClub getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(FootballClub awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getNoOfGoalsScoredByHomeTeam() {
        return this.noOfGoalsScoredByHomeTeam;
    }

    public void setNoOfGoalsScoredByHomeTeam(int noOfGoalsScoredByHomeTeam) {
        this.noOfGoalsScoredByHomeTeam = noOfGoalsScoredByHomeTeam;
    }

    public int getNoOfGoalsScoredByAwayTeam() {
        return this.noOfGoalsScoredByAwayTeam;
    }

    public void setNoOfGoalsScoredByAwayTeam(int noOfGoalsScoredByAwayTeam) {
        this.noOfGoalsScoredByAwayTeam = noOfGoalsScoredByAwayTeam;
    }

    public Date getMatchPlayedDate() {
        return this.matchPlayedDate;
    }

    public void setMatchPlayedDate(Date matchPlayedDate) {
        this.matchPlayedDate = matchPlayedDate;
    }

    //method to update the statistics of relevant clubs
    public void updateStatistics(){
        //updating the number of goals scored of both clubs
        homeTeam.setNoOfGoalsScored(homeTeam.getNoOfGoalsScored()+this.noOfGoalsScoredByHomeTeam);
        awayTeam.setNoOfGoalsScored(awayTeam.getNoOfGoalsScored()+this.noOfGoalsScoredByAwayTeam);

        //updating the number of goals conceded of both clubs
        homeTeam.setNoOfGoalsConceded(homeTeam.getNoOfGoalsConceded()+this.noOfGoalsScoredByAwayTeam);
        awayTeam.setNoOfGoalsConceded(awayTeam.getNoOfGoalsConceded()+this.noOfGoalsScoredByHomeTeam);

        //updating the number of matches played in both clubs
        homeTeam.setNoOfMatchesPlayed(homeTeam.getNoOfMatchesPlayed()+1);
        awayTeam.setNoOfMatchesPlayed(awayTeam.getNoOfMatchesPlayed()+1);

        //assigning points according to win or draw or defeat
        //if it is a win, winning team gets 3 points while other get none
        //if it is a draw, both team gets 1 point each
        //also updating whether its a win or draw or defeat to the relevant club
        if(this.noOfGoalsScoredByHomeTeam==this.noOfGoalsScoredByAwayTeam){
            homeTeam.setNoOfPoints(homeTeam.getNoOfPoints()+1);
            awayTeam.setNoOfPoints(awayTeam.getNoOfPoints()+1);

            homeTeam.setDraws(homeTeam.getDraws()+1);
            awayTeam.setDraws(awayTeam.getDraws()+1);
        }else if(this.noOfGoalsScoredByHomeTeam>this.noOfGoalsScoredByAwayTeam){
            homeTeam.setNoOfPoints(homeTeam.getNoOfPoints()+3);

            homeTeam.setWins(homeTeam.getWins()+1);
            awayTeam.setDefeats(awayTeam.getDefeats()+1);
        }else{
            awayTeam.setNoOfPoints(awayTeam.getNoOfPoints()+3);

            awayTeam.setWins(awayTeam.getWins()+1);
            homeTeam.setDefeats(homeTeam.getDefeats()+1);
        }
    }

    //overriding of equals method using homeTeam,awayTeam and matchPlayedDate attributes of the objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchPlayed)) return false;
        MatchPlayed matchPlayed = (MatchPlayed) o;
        return Objects.equals(this.homeTeam, matchPlayed.homeTeam) &&
                Objects.equals(this.awayTeam, matchPlayed.awayTeam) &&
                Objects.equals(this.matchPlayedDate, matchPlayed.matchPlayedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.homeTeam, this.awayTeam, this.matchPlayedDate);
    }
}
