package HomeWork7;

import java.util.Scanner;

/**
 * Created by gaara on 4/24/17.
 */

/*


1. Создать поток, который печатал бы текущее время каждую секунду.
Сделать это двумя способами - при помощи расширения класса Thread и при помощи реализации интерфейса Runnable.
Предусмотреть возможность его завершения путем ввода любого символа с клавиатуры.
2. Разработать пример взаимной блокировки двух потоков.
3. Создать класс с двумя отдельными счетчиками и объект этого класса.
Создать несколько одинаковых потоков, каждый из которых повторяет следующее:
сравнивает значение счетчиков и печатает результат сравнения, увеличивает первый счетчик,
 засыпает на 10 мсек, а затем увеличивает второй счетчик.  Сравнить работу программы при условии,
 что упомянутый блок кода синхронизирован и не синхронизирован.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Runnable Thread");
        WriteTimeRunnable wr = new WriteTimeRunnable();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            wr.interupt();
        }

        System.out.println("Normal Thread");
        WriteTimeThread wrt = new WriteTimeThread();
        wrt.start();

        sc = new Scanner(System.in);
        if (sc.hasNext()) {
            wrt.interupt();
        }

    }
}

