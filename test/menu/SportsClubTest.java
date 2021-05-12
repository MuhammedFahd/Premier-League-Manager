package menu;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SportsClubTest {
    @Test
    public void getName() {
        SportsClub sportsClub=new FootballClub();
        sportsClub.setName("youth club");
        String name=sportsClub.getName();
        assertEquals("youth club",name);

    }


    @Test
    public void getLocation() {
        SportsClub sportsClub=new FootballClub();
        sportsClub.setLocation("new york");
        String location=sportsClub.getLocation();
        assertEquals("new york",location);
    }

    @Test
    public void getWins() {
        SportsClub sportsClub=new FootballClub();
        sportsClub.setWins(5);
        int num=sportsClub.getWins();
        assertEquals(5,num);
    }

    @Test
    public void getDraws() {
        SportsClub sportsClub=new FootballClub();
        sportsClub.setDraws(6);
        int num=sportsClub.getDraws();
        assertEquals(6,num);
    }

    @Test
    public void getDefeats() {
        SportsClub sportsClub=new FootballClub();
        sportsClub.setDefeats(8);
        int num=sportsClub.getDefeats();
        assertEquals(8,num);
    }
}