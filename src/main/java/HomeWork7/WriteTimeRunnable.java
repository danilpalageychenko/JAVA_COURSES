package HomeWork7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * Created by gaara on 4/24/17.
 */
public class WriteTimeRunnable implements Runnable {
    Thread thread;
    boolean interapt = false;
    WriteTimeRunnable() {
        thread = new Thread(this,"WriteTimeRunnavle");
        thread.start();
    }

    public void interupt()
    {
        interapt = true;
    }

    @Override
    public void run() {
        while(true) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            System.out.println(sdf.format(cal.getTime()));
            if(interapt)
                break;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
