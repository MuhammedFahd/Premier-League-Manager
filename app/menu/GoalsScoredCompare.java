package menu;

import java.util.Comparator;

public class GoalsScoredCompare implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        if(o1.getNoOfGoalsScored()==o2.getNoOfGoalsScored()){
            return 0;
        }else if(o1.getNoOfGoalsScored()<o2.getNoOfGoalsScored()){
            return 1;
        }else{
            return -1;
        }
    }
}
