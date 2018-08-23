package PZ6;

import java.util.HashMap;

/**
 * Created by gaara on 06.09.16.
 */
public class App {
    public static void main(String[] args) {

        Runnable thr1 = new Runnable() {
            Thread thread = new Thread(this, "Пототок Runnable");

            public void run() {
                for (int i = 0; i < 5; i++) {

                    System.out.println(thread.getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thr2 = new Thread()
        {
            @Override
            public void run() {
                this.setName("Пототок Thread");
                for (int i = 0; i < 5; i++) {

                    System.out.println(this.getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

            //thr1.run();
            //thr2.start();


        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Сообщение 1",500);
        hm.put("Сообщение 2",1000);
        hm.put("Сообщение 3",2000);

       // MyShedule.intervalPrint(hm);

        //FileFinder.findFile("/home/gaara/IdeaProjects/MyMavenProject",".txt","PZ6LOG.txt");
        FileCopier.copyFile("/home/gaara/IdeaProjects/MyMavenProject","/home/gaara/IdeaProjects/PZ6Copied/");

    }
}
