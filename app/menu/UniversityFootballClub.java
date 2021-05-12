package menu;

public class UniversityFootballClub extends FootballClub{
    //basic attributes
    private String universityName;
    private String universityType; //whether its private,state or semi university

    //default constructor
    public UniversityFootballClub() {
    }

    ////constructor with parameters
    public UniversityFootballClub(String name,String location,String universityName,String universityType){
        super(name, location);
        this.universityName=universityName;
        this.universityType=universityType;
    }

    //setters for all the attributes
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    //getters for all the attributes
    public String getUniversityName() {
        return this.universityName;
    }
    public String getUniversityType() {
        return this.universityType;
    }

}