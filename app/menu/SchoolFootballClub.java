package menu;

public class SchoolFootballClub extends FootballClub{
    //basic attributes
    private int playingDivision; //division in which it plays such as: 1,2,3

    //default constructor
    public SchoolFootballClub(){
    }

    //constructor with parameters
    public SchoolFootballClub(String name,String location,int playingDivision){
        super(name, location);
        this.playingDivision=playingDivision;
    }

    //setters for all the attributes
    public void setPlayingDivision(int playingDivision) {
        this.playingDivision = playingDivision;
    }

    //getters for all the attributes
    public int getPlayingDivision() {
        return this.playingDivision;
    }

}
