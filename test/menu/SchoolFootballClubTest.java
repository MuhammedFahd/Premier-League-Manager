package menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolFootballClubTest {

    @Test
    public void getPlayingDivision() {
        SchoolFootballClub schoolFootballClub=new SchoolFootballClub();
        schoolFootballClub.setPlayingDivision(1);
        int num=schoolFootballClub.getPlayingDivision();
        assertEquals(1,num);
    }
}