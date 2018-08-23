package HomeWork7;

/**
 * Created by gaara on 4/24/17.
 */
public class Second {
    synchronized void hello(Second second) {
        System.out.println();
        second.meth2();
    }
    synchronized void meth2() {
    }

    public static void main(String[] args) {
        final Second second1 = new Second();
        final Second second2 = new Second();
        Thread thread1 = new Thread(() -> second1.hello(second2));
        Thread thread2 = new Thread(() -> second2.hello(second1));
        thread1.start();
        thread2.start();
    }
}
