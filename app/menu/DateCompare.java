package menu;

import java.util.Comparator;

public class DateCompare implements Comparator<MatchPlayed> {
    @Override
    public int compare(MatchPlayed o1, MatchPlayed o2) {
        return o1.getMatchPlayedDate().compareTo(o2.getMatchPlayedDate());
    }
}
