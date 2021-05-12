package menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    @Test
    public void getNoOfGoalsScored() {
        FootballClub footballClub=new FootballClub();
        footballClub.setNoOfGoalsScored(5);
        int num=footballClub.getNoOfGoalsScored();
        assertEquals(5,num);
    }

    @Test
    public void getNoOfGoalsConceded() {
        FootballClub footballClub=new FootballClub();
        footballClub.setNoOfGoalsConceded(6);
        int num=footballClub.getNoOfGoalsConceded();
        assertEquals(6,num);
    }

    @Test
    public void getNoOfPoints() {
        FootballClub footballClub=new FootballClub();
        footballClub.setNoOfPoints(10);
        int num=footballClub.getNoOfPoints();
        assertEquals(10,num);
    }

    @Test
    public void getNoOfMatchesPlayed() {
        FootballClub footballClub=new FootballClub();
        footballClub.setNoOfMatchesPlayed(6);
        int num=footballClub.getNoOfMatchesPlayed();
        assertEquals(6,num);
    }
}