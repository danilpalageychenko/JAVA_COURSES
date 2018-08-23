package PZ3;

import java.time.LocalTime;
import java.util.Date;


/**
 * Created by gaara on 12.08.16.
 */
public class Film {
    static int id = 0;
    String name;
    String description;
    Date startDate;
    Date endDate;

    public Film(String name, String description ,Date startDate, Date endDate) {

        id++;
        setName(name);
        setDescription(description);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getId() {
        return id;
    }
}
