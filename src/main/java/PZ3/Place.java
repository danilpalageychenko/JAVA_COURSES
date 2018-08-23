package PZ3;

/**
 * Created by gaara on 12.08.16.
 */
public class Place {
    int x;
    int y;
    placeStatus ps;

    public Place(int x, int y, placeStatus ps) {
        setX(x);
        setY(y);
        setPs(ps);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public placeStatus getPs() {
        return ps;
    }

    public void setPs(placeStatus ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return x+","+y+","+ps.getId()+";";
    }
}