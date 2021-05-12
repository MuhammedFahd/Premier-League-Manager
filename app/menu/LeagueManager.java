package menu;

import java.io.IOException;

public interface LeagueManager {
    void addFootballClub(FootballClub footballClub);
    void deleteFootballClub(String footballClubName);
    void displayStatistics(String footballClubName);
    void displayLeagueTable();
    void addMatchPlayed(MatchPlayed matchPlayed);
    void saveData(String fileName) throws IOException;
    void retrieveData(String fileName) throws IOException, ClassNotFoundException;
}
