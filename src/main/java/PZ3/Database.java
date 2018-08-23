package PZ3;

import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.datatype.Duration;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaara on 12.08.16.
 */
public class Database {

        //датабейз хранит билеты которые привязаны к фильму в определенном зале

    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Hall> halls = new ArrayList<Hall>();
    public static ArrayList<Film> films = new ArrayList<Film>();

    public static void addUser(String login, String pass, String email,Rights right)
    {
        users.add(new User(login, DigestUtils.md5Hex(pass),email,right));

        String quary = "INSERT IGNORE INTO test.users (`login`,`pass`,`email`,`right`) VALUES ('"+login+"',MD5('"+pass+"'),'"+email+"','"+right.toString()+"')";
        MysqlConnector.makeQuaryUpdate(quary);

    }
    private static String convertPlaces(ArrayList<Place> places)
    {
        String ans = new String();
        for (Place place : places)
        {
            ans+=place.toString();
        }
        return ans;
    }
    public static void addHall(String name, ArrayList<Place> places)
    {
        halls.add(new Hall(name,places));
        //Hall places structure : 1,1,0;1,2,0;0,3,0;

        String quary = "INSERT IGNORE INTO test.halls (`name`,`places`) VALUES ('"+name+"','"+convertPlaces(places)+"')";
        MysqlConnector.makeQuaryUpdate(quary);


    }
    public static void addFilm(String name, String description, Date startDate, Date endDate)
    {
        films.add(new Film(name,description,startDate,endDate));
        //time Structure 10:11:12 HH:MM:SS

        String quary = "INSERT IGNORE INTO test.films (`name`,`description`,`startDate`,`endDate`) VALUES ('"+name+"','"+description+"','"+startDate.toString()+"','"+endDate.toString()+"')";
        MysqlConnector.makeQuaryUpdate(quary);

    }
    public static void addSession(int filmId, int hallId, LocalTime start, LocalTime end)
    {
        ArrayList<Place> places = new ArrayList<Place>();
        String pls = new String();

        pls = MysqlConnector.makeQuaryString("SELECT places FROM halls WHERE id="+hallId,"places");

        Pattern pt = Pattern.compile(pls);
        Matcher mt = pt.matcher("(\\d+),(\\d+),(\\d+);");
        while(mt.find())
        {
            places.add(new Place(Integer.parseInt(mt.group(0)),Integer.parseInt(mt.group(1)),placeStatus.getPSById(Integer.parseInt(mt.group(2)))));
        }


        String quary = "INSERT IGNORE INTO test.sessions (`filmid`,`hallid`,`start`,`end`,`places`) VALUES ('"+filmId+"','"+hallId+"','"+start.format(DateTimeFormatter.ISO_TIME)+"','"+end.format(DateTimeFormatter.ISO_TIME)+"','"+pls+"')";
        MysqlConnector.makeQuaryUpdate(quary);
    }
    public static void createTicket(int userid,int sessionid, Place place)
    {


        String quary = "INSERT IGNORE INTO test.tickets (`userid`,`sessionid`,`place`) VALUES ('"+userid+"','"+sessionid+"','"+place+"')";
        MysqlConnector.makeQuaryUpdate(quary);

    }
    public static Film getFilm(int id)
    {
        return films.get(id);
    }
}
