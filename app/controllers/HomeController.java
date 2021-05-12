package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import menu.*;
import menu.Date;
import play.libs.Json;
import play.mvc.*;

import java.io.*;
import java.util.*;


public class HomeController extends Controller {

    //method which returns all the football club data after retrieving from the file
    public Result footballClubList() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> footballClubs=new ArrayList<>();
        //reads data from the relevant file and add it to the array list
        FileInputStream fileInputStream=new FileInputStream("app/PremierLeagueClubs.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                footballClubs.add((FootballClub) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        Collections.sort(footballClubs);  //sorts the football clubs list according to the points
        JsonNode jsonNode = Json.toJson(footballClubs);
        return ok(jsonNode).as("application/json");
    }

    //method which returns the football club list after sorting according to the wins
    public Result winsSortedFootballClubList() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> sortedFootballClubs=new ArrayList<>();
        WinsCompare winsCompare=new WinsCompare();
        //reads data from the relevant file and add it to the array list
        FileInputStream fileInputStream=new FileInputStream("app/PremierLeagueClubs.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                sortedFootballClubs.add((FootballClub) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        Collections.sort(sortedFootballClubs,winsCompare); //sorts the football clubs list according to the wins
        JsonNode jsonNode = Json.toJson(sortedFootballClubs);
        return ok(jsonNode).as("application/json");
    }

    //method which returns the football club list after sorting according to the goals scored
    public Result goalsSortedFootballClubList() throws IOException, ClassNotFoundException {
        ArrayList<FootballClub> sortedFootballClubs=new ArrayList<>();
        GoalsScoredCompare goalsScoredCompare=new GoalsScoredCompare();

        //reads data from the relevant file and add data to the array list
        FileInputStream fileInputStream=new FileInputStream("app/PremierLeagueClubs.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                sortedFootballClubs.add((FootballClub) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        Collections.sort(sortedFootballClubs,goalsScoredCompare); //sorts the football clubs list according to the goals scored
        JsonNode jsonNode = Json.toJson(sortedFootballClubs);
        return ok(jsonNode).as("application/json");
    }

    //method which returns all the played matches data after retrieving from the file
    public Result matchesPlayedList() throws IOException, ClassNotFoundException {
        ArrayList<MatchPlayed> matchesPlayed=new ArrayList<>();

        //reads data from the relevant file and add it to the array list
        FileInputStream fileInputStream=new FileInputStream("app/MatchesPlayed.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                matchesPlayed.add((MatchPlayed) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }

        JsonNode jsonNode = Json.toJson(matchesPlayed);
        return ok(jsonNode).as("application/json");
    }

    //method which returns the played matches list after sorting according to the date
    public Result sortedMatchesPlayedList() throws IOException, ClassNotFoundException {
        ArrayList<MatchPlayed> sortedMatchesPlayed=new ArrayList<>();
        DateCompare dateCompare=new DateCompare();

        //reads data from the relevant file and add it to the array list
        FileInputStream fileInputStream=new FileInputStream("app/MatchesPlayed.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                sortedMatchesPlayed.add((MatchPlayed) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }

        Collections.sort(sortedMatchesPlayed,dateCompare); //sorts the played matches list according to the date
        JsonNode jsonNode = Json.toJson(sortedMatchesPlayed);
        return ok(jsonNode).as("application/json");
    }


    //method which generates a random match and returns it
    public Result randomMatchPlayed() throws IOException, ClassNotFoundException {
        ArrayList<MatchPlayed> matchesPlayed=new ArrayList<>();
        ArrayList<FootballClub> footballClubs=new ArrayList<>();

        //reads all the data from all files and add them to the relevant array lists
        FileInputStream fileInputStream=new FileInputStream("app/MatchesPlayed.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        for(;;){
            try{
                matchesPlayed.add((MatchPlayed) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        FileInputStream fileInputStream2=new FileInputStream("app/PremierLeagueClubs.txt");
        ObjectInputStream objectInputStream2=new ObjectInputStream(fileInputStream2);
        for(;;){
            try{
                footballClubs.add((FootballClub) objectInputStream2.readObject());
            } catch (EOFException e) {
                break;
            }
        }

        //generating a random match
        boolean duplicateMatch=true;
        MatchPlayed newMatchPlayed = null;
        while(duplicateMatch) {
            Random random = new Random();
            int homeTeam = random.nextInt(footballClubs.size());
            int awayTeam = random.nextInt(footballClubs.size());
            while(true) {
                if (awayTeam == homeTeam) {
                    awayTeam = random.nextInt(footballClubs.size());
                }else{
                    break;
                }
            }
            int homeTeamGoals = random.nextInt(10);
            int awayTeamGoals = random.nextInt(10);

            int year = 2020;
            int month = 1 + random.nextInt(12);
            int day = 1 + random.nextInt(30);

            newMatchPlayed = new MatchPlayed(footballClubs.get(homeTeam)
                    , footballClubs.get(awayTeam)
                    , homeTeamGoals
                    , awayTeamGoals
                    , new Date(day, month, year));

            for (MatchPlayed matchPlayed1 : matchesPlayed) {
                if (!newMatchPlayed.equals(matchPlayed1)) {
                    duplicateMatch=false;
                }else{
                    duplicateMatch=true;
                }
            }
        }

        matchesPlayed.add(newMatchPlayed);  //adding the generated match to the played matches list
        newMatchPlayed.updateStatistics();  //updating the statistics of relevant clubs

        //saving all the data into all the files
        FileOutputStream fileOutputStream=new FileOutputStream("app/MatchesPlayed.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        for(MatchPlayed matchPlayed:matchesPlayed){
            objectOutputStream.writeObject(matchPlayed);
        }

        FileOutputStream fileOutputStream2=new FileOutputStream("app/PremierLeagueClubs.txt");
        ObjectOutputStream objectOutputStream2=new ObjectOutputStream(fileOutputStream2);
        for(FootballClub footballClub:footballClubs){
            objectOutputStream2.writeObject(footballClub);
        }

        ArrayList<MatchPlayed> newMatchesPlayed=new ArrayList<>();
        newMatchesPlayed.add(newMatchPlayed);
        JsonNode jsonNode = Json.toJson(newMatchesPlayed);
        return ok(jsonNode).as("application/json");
    }

    public Result postTest(){
        JsonNode jsonNode = Json.toJson("something");
        return ok(jsonNode).as("application/json");
    }
}
