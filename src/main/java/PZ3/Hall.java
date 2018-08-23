package PZ3;

import java.util.ArrayList;

/**
 * Created by gaara on 12.08.16.
 */
public class Hall {
    static int id = 0;
    String name;
    ArrayList<Place> places;






    public Hall(String name, ArrayList<Place> places) {
        id++;
        setName(name);
        setPlaces(places);
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getId() {
        return id;
    }
}
