package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //create instance of PremierLeagueManager
    public static PremierLeagueManager premierLeagueManager=new PremierLeagueManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //retrieving all the save data from the relevant files and load it to the program
        try {
            premierLeagueManager.retrieveData("app/PremierLeagueClubs.txt");
            premierLeagueManager.retrieveData("app/MatchesPlayed.txt");
        }catch(FileNotFoundException e){
            System.out.println("");
        }
        System.out.println("WELCOME TO PREMIER LEAGUE MANAGER\n");
        menuLoop:
        while(true) {
            displayMenu();  //call the method to display the menu
            Scanner menuInput = new Scanner(System.in);
            int selection=0;
            try {
                System.out.println("please enter your selection:");
                selection = menuInput.nextInt();
            }catch (InputMismatchException e){
                System.out.println("invalid input!!");
                System.out.println("please enter an number");
                continue;
            }

            switch (selection) {
                case 1:
                    addFootballClub();
                    break;
                case 2:
                    deleteFootballClub();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    premierLeagueManager.displayLeagueTable();
                    break;
                case 5:
                    addMatchPlayed();
                    break;
                case 6:
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://localhost:4200/play"});
                case 7:
                    break menuLoop;
            }
            //saves all the data to the relevant files which are input by the user
            premierLeagueManager.saveData("app/PremierLeagueClubs.txt");
            premierLeagueManager.saveData("app/MatchesPlayed.txt");
        }
    }

    //method to add a played match
    private static void addMatchPlayed() {
        boolean error=false;   //variable to identify when an error is occured
        Scanner input=new Scanner(System.in);
        Scanner input1=new Scanner(System.in);
        System.out.println("please enter the name of home team:");
        String homeTeam=input.nextLine();
        System.out.println("please enter the name of away team:");
        String awayTeam=input.nextLine();

        //try and catch block is used to identify whether user has input integer values for first two inputs
        //if so then warn the user with appropriate messages
        //otherwise the program proceed with rest of the functions
        try{
            int h=Integer.parseInt(homeTeam);
            int a=Integer.parseInt(awayTeam);
            System.out.println("inappropriate input!!!!");
            System.out.println("please re-enter with text value!!!!");
            error=true;   //variable becomes true when user inputs integer values for string
        }catch(NumberFormatException e) {
            error=false;
        }

        //asking for the rest of the inputs if there were no errors with the previous inputs
        if(!error) {
            //this try and catch block is used to check whether user inputs string values
            //if so then it warns the user and ask to retry
            try {
                System.out.println("Score:");
                System.out.println("please enter the number of goals scored by home team:");
                int homeTeamGoals = input.nextInt();
                System.out.println("please enter the number of goals scored by away team:");
                int awayTeamGoals = input.nextInt();

                System.out.println("Match Date:");
                System.out.println("enter the day:");
                int day = input.nextInt();
                System.out.println("enter the month:");
                int month = input.nextInt();
                System.out.println("enter the year:");
                int year = input.nextInt();

                System.out.println("Are you sure you want to add the above played match to the premier league?(y/n)");
                String answer=input1.nextLine();
                answer=answer.toLowerCase();
                //adds the played match or not according to the response of the user
                if(answer.equals("y")) {
                    MatchPlayed matchPlayed = null;
                    if(homeTeamGoals<0 || awayTeamGoals<0){
                        System.out.println("please enter positive values!!");
                    }else{
                        matchPlayed = new MatchPlayed(
                                premierLeagueManager.getFootballClub(homeTeam.toLowerCase())
                                , premierLeagueManager.getFootballClub(awayTeam.toLowerCase())
                                , homeTeamGoals
                                , awayTeamGoals
                                , new Date(day, month, year));
                        //calling the method to add the played match to the premier league
                        premierLeagueManager.addMatchPlayed(matchPlayed);
                    }
                }else if(answer.equals("n")){
                    System.out.println("above match played is not added to the premier league!!");
                }else{
                    System.out.println("invalid response!!!!!");
                    System.out.println("please try again!!!!!");
                }


            } catch (InputMismatchException e) {
                System.out.println("invalid input!!!");
                System.out.println("please enter valid input!!!");
            }
        }



    }

    //method to display statistics of a club that is entered by the user
    private static void displayStatistics() {
        //taking user input
        Scanner input=new Scanner(System.in);
        System.out.println("please enter the name of the club:");
        String name=input.nextLine();


        //try and catch block is used to identify whether user has input integer values
        //if so then warn the user with appropriate messages
        //otherwise the program proceed with rest of the functions
        try{
            int n=Integer.parseInt(name);
            System.out.println("inappropriate input!!!!");
            System.out.println("please re-enter with text value!!!!");
        }catch(NumberFormatException e) {
            //displays the statistics by calling the method from PremierLeagueManager
            premierLeagueManager.displayStatistics(name.toLowerCase());
        }
    }

    //method to delete football club from the premier league
    private static void deleteFootballClub() {
        //taking user input
        Scanner input=new Scanner(System.in);
        System.out.println("please enter the name of the club you want to delete:");
        String name=input.nextLine();

        //try and catch block is used to identify whether user has input integer values
        //if so then warn the user with appropriate messages
        //otherwise the program proceed with rest of the functions
        try{
            int n=Integer.parseInt(name);
            System.out.println("inappropriate input!!!!");
            System.out.println("please re-enter with text value!!!!");
        }catch(NumberFormatException e){
            System.out.println("Are you sure you want to delete club "+name+" from the premier league?(y/n)");
            String answer=input.nextLine();
            answer=answer.toLowerCase();

            //deletes the club or not according to the response of the user
            if(answer.equals("y")){
                premierLeagueManager.deleteFootballClub(name.toLowerCase());  //calling the delete method from PremierLeagueManager class
            }else if(answer.equals("n")){
                System.out.println("club "+name+" is not removed from the premier league!!");
            }else{
                System.out.println("invalid response!!!!!");
                System.out.println("please try again!!!!!");


            }
        }

    }

    //method to add football club to the premier league
    private static void addFootballClub() {
        //taking user inputs
        Scanner input=new Scanner(System.in);
        System.out.println("please enter the name of the club:");
        String name=input.nextLine();
        System.out.println("please enter the location of the club:");
        String location=input.nextLine();

        //try and catch block is used to identify whether user has input integer values
        //if so then warn the user with appropriate messages
        //otherwise the program proceed with rest of the functions
        try{
            int n=Integer.parseInt(name);
            int l=Integer.parseInt(location);
            System.out.println("inappropriate input!!!!");
            System.out.println("please re-enter with text value!!!!");
        }catch(NumberFormatException e){
            System.out.println("Are you sure you want to add club "+name+" to the premier league?(y/n)");
            String answer=input.nextLine();
            answer=answer.toLowerCase();

            //adds the club or not according to the response of the user
            if(answer.equals("y")) {
                //creating a FootballClub object and adding it to the premier league
                FootballClub footballClub = new FootballClub(name, location);
                premierLeagueManager.addFootballClub(footballClub);
            }else if(answer.equals("n")){
                System.out.println("club "+name+" is not added to the premier league!!");
            }else{
                System.out.println("invalid response!!!!!");
                System.out.println("please try again!!!!!");
            }
        }

    }

    //method to display the selection menu
    public static void displayMenu(){
        System.out.println("select from the menu below:");
        System.out.println("press 1: Add new football club to the premier league");
        System.out.println("press 2: Delete existing club from the premier league");
        System.out.println("press 3: Display statistics of a selected club");
        System.out.println("press 4: Display the premier league table");
        System.out.println("press 5: Add a played match");
        System.out.println("press 6: Open angular GUI");
        System.out.println("press 7: Exit");
    }
}
