package HomeWork7;

/**
 * Created by gaara on 4/24/17.
 */
public class Third {
    public static void main(String[] args) {

        new Thread(Timer::count).start();
        new Thread(Timer::count).start();
    }
}



