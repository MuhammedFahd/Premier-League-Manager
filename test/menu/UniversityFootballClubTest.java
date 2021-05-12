package menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    @Test
    public void getUniversityName() {
        UniversityFootballClub universityFootballClub=new UniversityFootballClub();
        universityFootballClub.setUniversityName("iit");
        String name=universityFootballClub.getUniversityName();
        assertEquals("iit",name);
    }

    @Test
    public void getUniversityType() {
        UniversityFootballClub universityFootballClub=new UniversityFootballClub();
        universityFootballClub.setUniversityType("private");
        String type=universityFootballClub.getUniversityType();
        assertEquals("private",type);
    }
}