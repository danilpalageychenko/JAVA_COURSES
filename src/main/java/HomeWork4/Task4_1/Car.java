package HomeWork4.Task4_1;

/**
 * Created by gaara on 4/24/17.
 */
public class Car {
    private String marka;
    private int chena;

    public Car(String marka, int chena) {
        setMarka(marka);
        setChena(chena);
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getChena() {
        return chena;
    }

    public void setChena(int chena) {
        this.chena = chena;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", chena=" + chena +
                '}';
    }
}
