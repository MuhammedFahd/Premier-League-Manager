package menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchPlayedTest {

    @Test
    public void getHomeTeam() {
        MatchPlayed matchPlayed=new MatchPlayed();
        matchPlayed.setHomeTeam(new FootballClub("arsenal","england"));
        FootballClub team=matchPlayed.getHomeTeam();
        assertEquals(new FootballClub("arsenal","england"),team);
    }

    @Test
    public void getAwayTeam() {
        MatchPlayed matchPlayed=new MatchPlayed();
        matchPlayed.setAwayTeam(new FootballClub("liverpool","england"));
        FootballClub team=matchPlayed.getAwayTeam();
        assertEquals(new FootballClub("liverpool","england"),team);
    }

    @Test
    public void getNoOfGoalsScoredByHomeTeam() {
        MatchPlayed matchPlayed=new MatchPlayed();
        matchPlayed.setNoOfGoalsScoredByHomeTeam(5);
        int num=matchPlayed.getNoOfGoalsScoredByHomeTeam();
        assertEquals(5,num);
    }

    @Test
    public void getNoOfGoalsScoredByAwayTeam() {
        MatchPlayed matchPlayed=new MatchPlayed();
        matchPlayed.setNoOfGoalsScoredByAwayTeam(4);
        int num=matchPlayed.getNoOfGoalsScoredByAwayTeam();
        assertEquals(4,num);
    }

}