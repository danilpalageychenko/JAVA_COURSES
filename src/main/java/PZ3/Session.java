package PZ3;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaara on 15.08.16.
 */
public class Session {
    int filmId;
    int hallId;
    LocalTime start;
    LocalTime end;
    ArrayList<Place> places;

    public Session(int filmId, int hallId, LocalTime start, LocalTime end,ArrayList<Place> places) {
        this.filmId = filmId;
        this.hallId = hallId;
        this.start = start;
        this.end = end;
        this.places = places;

    }
}
