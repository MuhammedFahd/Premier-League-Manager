package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class PremierLeagueManager implements LeagueManager{
    private ArrayList<FootballClub> premierLeagueClubList=new ArrayList<>(); //list to store all the football clubs in premier league
    private ArrayList<MatchPlayed> matchesPlayedList=new ArrayList<>();  //list to store all the matches played

    //method to add football club to premier league
    @Override
    public void addFootballClub(FootballClub footballClub) {
        //checks whether the entered football club already exist or not
        if(premierLeagueClubList.contains(footballClub)){
            System.out.println(footballClub.getName()+" already exists in the premier league");
            System.out.println("check and please re-enter properly!!!!");
        }else{
            //if it doesn't exist then it adds to the premier league
            premierLeagueClubList.add(footballClub);
            System.out.println(footballClub.getName()+" has been added to the premier league");
        }
    }

    //method to delete football club from the premier league
    @Override
    public void deleteFootballClub(String footballClubName) {
        boolean deleted=false;
        //checks whether entered club is available in the premier league by going through the list
        for(FootballClub footballClub:premierLeagueClubList){
            if(footballClub.getName().toLowerCase().equals(footballClubName)){
                //if it is available then it removes
                premierLeagueClubList.remove(footballClub);
                System.out.println(footballClub.getName()+" has been removed from the premier league");
                deleted=true;
                break;
            }
        }
        //if the entered club is not available then notifies the user to check whether he entered properly
        if(!deleted){
            System.out.println("The club that you have entered doesn't exist in the premier league");
            System.out.println("please re-enter properly!!!");
        }
    }

    //method to display statistics of a club
    @Override
    public void displayStatistics(String footballClubName) {
        boolean displayed=false;
        //checks whether entered club is available in the premier league and display the statistics of that club
        for(FootballClub footballClub:premierLeagueClubList){
            if(footballClub.getName().toLowerCase().equals(footballClubName)){
                System.out.println("statistics of football club "+footballClub.getName()+"\n");
                System.out.println("No of wins: "+footballClub.getWins());
                System.out.println("No of draws: "+footballClub.getDraws());
                System.out.println("No of defeats: "+footballClub.getDefeats());
                System.out.println("No of goals scored: "+footballClub.getNoOfGoalsScored());
                System.out.println("No of goals conceded: "+footballClub.getNoOfGoalsConceded());
                System.out.println("No of points: "+footballClub.getNoOfPoints());
                System.out.println("No of matches played: "+footballClub.getNoOfMatchesPlayed());
                displayed=true;
                break;
            }
        }
        //if the entered club is not available then notifies the user to check whether he entered properly
        if(!displayed){
            System.out.println("The club that you have entered doesn't exist in the premier league");
            System.out.println("please re-enter properly!!!");
        }
    }

    //method to display the premier league table
    @Override
    public void displayLeagueTable() {
        Collections.sort(premierLeagueClubList); //sorts the list in descending order to points
        System.out.println("footballclub\tmatchesplayed\twins\tdraws\tdefeats\tpoints\tgoaldifference");
        for(FootballClub footballClub:premierLeagueClubList){
            System.out.format("%10s %13s %9s %8s %8s %8s %10s"
                    ,footballClub.getName()
                    ,footballClub.getNoOfMatchesPlayed()
                    ,footballClub.getWins()
                    ,footballClub.getDraws()
                    ,footballClub.getDefeats()
                    ,footballClub.getNoOfPoints()
                    ,footballClub.getGoalDifference());
            System.out.println("");
        }
    }

    //method to add match played and to update the statistics of relevant clubs
    @Override
    public void addMatchPlayed(MatchPlayed matchPlayed) {
        //checks whether the match has been already added to the premier league
        if(matchesPlayedList.contains(matchPlayed)){
            System.out.println("This match is already added to the premier league!!!!");
        }else{
            //if it doesn't exist then it adds to the premier league
            matchesPlayedList.add(matchPlayed);
            matchPlayed.updateStatistics(); //update the statistics of the relevant clubs
            System.out.println("match has been added to the premier league successfully");
        }

    }

    //method to save all the data that has been entered by the user to the relevant files
    @Override
    public void saveData(String fileName) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

        //checks whether to which file data should be saved
        if(fileName.equals("app/PremierLeagueClubs.txt")){
            for(FootballClub footballClub:premierLeagueClubList){
                objectOutputStream.writeObject(footballClub);
            }
        }else if(fileName.equals("app/MatchesPlayed.txt")){
            for(MatchPlayed matchPlayed:matchesPlayedList){
                objectOutputStream.writeObject(matchPlayed);
            }
        }
        System.out.println("successfully saved data");
    }

    //method to retrieve all the saved data from the relevant file
    @Override
    public void retrieveData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(fileName);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        //checks whether from which file the data should be retrieved
        if(fileName.equals("app/PremierLeagueClubs.txt")){
            for(;;){
                try{
                    premierLeagueClubList.add((FootballClub) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        }else if(fileName.equals("app/MatchesPlayed.txt")){
            for(;;){
                try{
                    matchesPlayedList.add((MatchPlayed) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        }
        System.out.println("data retrieved successfully");

    }

    //method to get the relevant club object using its name
    public FootballClub getFootballClub(String footballClubName){
        FootballClub foundFootballClub = null;
        for(FootballClub footballClub:premierLeagueClubList){
            if(footballClub.getName().toLowerCase().equals(footballClubName)){
                foundFootballClub=footballClub;
                break;
            }
        }
        return foundFootballClub;
    }

    public ArrayList<FootballClub> getPremierLeagueClubList(){
        return premierLeagueClubList;
    }
}
