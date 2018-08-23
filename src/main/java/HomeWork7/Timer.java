package HomeWork7;

/**
 * Created by gaara on 4/24/17.
 */
class Timer {
    static int count1 = 0;
    static int count2 = 0;
    Timer timer = this;

    static void count() {
        while (true) {
            add();
        }
    }

    /*synchronized*/ static void add(){
        System.out.println(Thread.currentThread() + " - " + (count1 == count2));
        count1++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count2++;
    }

}
