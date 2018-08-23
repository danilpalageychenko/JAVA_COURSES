package HomeWork4.Task4_2.part2;


import java.util.Iterator;

/**
 * Created by gaara on 4/24/17.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();
        deque.addFirst(433);
        deque.addLast(8.88);
        for (Number element : deque) {
            System.out.println(element);
        }

        System.out.println("----------");
        System.out.println(deque);
        System.out.println("----------");

        Iterator<Number> it = deque.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println("----------");

        System.out.println(deque);
    }
}
