package HomeWork4.Task4_2.part3;

import java.util.Arrays;

/**
 * Created by gaara on 4/24/17.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();
        deque.addFirst(433);
        deque.addLast(8.88);
        deque.addLast(3.83);
        deque.addLast(12.8);
        deque.addLast(165);
        deque.addLast(33);
        ListIterator<Number> listIt = deque.listIterator();

        System.out.println(deque);

        System.out.println("--------");

        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        System.out.println("--------");

        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }

        System.out.println("--------");

        int i=0;
        while (listIt.hasNext()) {
            listIt.next();
            listIt.set(i);
            i++;
        }
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }

        System.out.println("--------");

        while (listIt.hasNext()) {
            listIt.next();
            listIt.remove();
        }
        System.out.println(deque);












    }
}
