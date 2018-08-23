package PZ3;

/**
 * Created by gaara on 12.08.16.
 */
public class Ticket {
    static int id = 0;
    int userid;
    int sessionid;
    Place userplace;


    public Ticket(int userid, int sessionid , Place userplace) {
        id++;
        setUserid(userid);
        setSessionid(sessionid);
        setUserplace(userplace);
    }

    public static int getId() {
        return id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }

    public void setUserplace(Place userplace) {
        this.userplace = userplace;
    }

    @Override
    public String toString() {
        return "Ticket #" + id +
                "\nuser=" + userid +
                "\nsession=" + sessionid +
                "\nplace=" + userplace.getX() + " " + userplace.getY();
    }
}
