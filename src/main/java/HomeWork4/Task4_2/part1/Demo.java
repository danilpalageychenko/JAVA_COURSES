package HomeWork4.Task4_2.part1;

import java.util.Arrays;

/**
 * Created by gaara on 4/24/17.
 */
public class Demo {
    public static void main(String[] args) {
        MyDeque <Number> deque  = new MyDequeImpl<>();
        // добавить элемент в начало списка
        deque.addFirst(433);
        deque.addFirst(123);
        // добавить элемент в конец списка
        deque.addLast(8.88);
        deque.addLast(7.63);
        System.out.println("Добавить элемент в начало списка и добавить элемент в конец списка: " + deque);

        // получить элемент из начала списка и удалить его
        deque.removeFirst();
        System.out.println("Получить элемент из начала списка и удалить его: " + deque);
        // получить элемент из конца списка и удалить его
        deque.removeLast();
        System.out.println("Получить элемент из конца списка и удалить его" + deque);

        // получить элемент из начала списка, не удаляя его
        System.out.println("Получить элемент из начала списка, не удаляя его: " + deque.getFirst());

        // получить элемент из конца списка, не удаляя его
        System.out.println("Получить элемент из конца списка, не удаляя его: " + deque.getLast());

        // проверить, содержится ли объект o в списке
        // (с помощью equals)
        System.out.println("Проверить, содержится ли объект O(433) в списке(с помощью equals): " + deque.contains(433));

        // вернуть массив элементов из списка
        // (сохраняя упорядоченность элементов списка)
        System.out.println("Вернуть массив элементов из списка" + Arrays.toString(deque.toArray()));

        // вернуть количество элементов в списке
        System.out.println("Вернуть количество элементов в списке: " + deque.size());

        // проверить, содержит ли список все элементы списка deque
        //boolean containsAll(MyDeque<? extends E> deque);
        MyDeque <Number> deque2  = new MyDequeImpl<>();
        deque2.addFirst(433);
        deque2.addLast(8.88);
        System.out.println("Проверить, содержит ли список все элементы списка deque: " + deque2.containsAll(deque));

        // очистить список
        deque.clear();
        System.out.println("Очистить список: " + deque);

    }
}
