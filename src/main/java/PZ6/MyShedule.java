package PZ6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaara on 06.09.16.
 */
public class MyShedule {
    static void intervalPrint(HashMap<String,Integer> map)
    {
        for (Map.Entry entr: map.entrySet()) {
            Thread thr = new Thread() {

                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        try {
                            System.out.println(entr.getKey());
                            Thread.sleep((Integer)entr.getValue());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thr.start();
            try {
                thr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
