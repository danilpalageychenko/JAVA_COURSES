package PZ3;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static PZ3.placeStatus.*;

/**
 * Created by gaara on 12.08.16.
 */
public class App {

    public static void main(String[] args) {
        //create film
        //Database.addFilm("FilmName","Good Film",new GregorianCalendar(2016, Calendar.JUNE,10).getTime(),new GregorianCalendar(2016, Calendar.JULY,01).getTime());

        //create Hall
        /*
        ArrayList<Place> placestmp= new ArrayList<Place>();
        for (int i = 0;i<10;i++)
            for (int j = 0;j<10;j++)
                placestmp.add(new Place(i,j,placeStatus.EMPTY));

        Database.addHall("Red",placestmp);
        */
        //create user
        //Database.addUser("Newbue","mypass","My@mail.ru",Rights.User);
        //create session
        //Database.addSession(1,1,LocalTime.of(10,0),LocalTime.of(12,10));
        //create ticket
        Database.createTicket(0,0,new Place(5,5,placeStatus.BOUGHT));


        System.out.println(MysqlConnector.makeQuaryString("SELECT place FROM tickets WHERE id=8","place"));


    }
}
