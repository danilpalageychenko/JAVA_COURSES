package HomeWork3;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by gaara on 16.08.16.
 */

/*
Создать Generic хранилище данных(GenericStorage). В качестве хранилища использовать массив. Должно быть реализовано CRUD(create read update delete — «Создание чтение обновление удаление») операций.
Детальное описание:
1. Создать конструктор без параметров. При вызове такого конструктора должен инициализироваться массив длиной 10.
2. Создать конструктор с параметром (int size). Size - размер массива.
3. Метод add(T obj), который добавит новый элемент в хранилище в конец
4. Метод T get(int index), который возвратит элемент по индексу в масиве.
5. Метод T[] getAll(), который вернет массив элементов. (Распечатать массив при помощи Arrays.toString(<Ваш массив>))
6. Метод update(int index, T obj), который подменит объект по заданной позиции только, если на этой позиции уже есть элемент.
7. Meтод delete(int index), который удалит элемент по индексу и захлопнет пустую ячейку в массиве, если на этой позиции уже есть элемент.
8. Метод delete(T obj), который удалит заданный объект из массива
9. Метод который возвратит размер массива ЗАПОЛНЕНОГО
Примечание:
нужно всегда хранить индекс ячейки массива, который указывает на позицию следующую после последнего элемента. Изначально это 0 так как массив пуст, после добавления первого элемента индекс указывает на 1 и т.д.
не забывайте что переменная index (get(int index), update(int index, T obj), delete(int index) ) должна всегда попадать в рамки 0 - индекс последнего элемента.
*/

public class GenericStorage<T> {

    private final int DEFAULT_SIZE = 10;
    int next = 0;
    int size;
    Object[] storage;
    public GenericStorage()
    {
        storage = new Object[DEFAULT_SIZE];
        this.size = 10;
    }
    public GenericStorage(int size)
    {
        if (size > 0)
            storage = new Object[size];
        this.size = size;
    }
    public void add(T obj)
    {
        size++;
        if(next < size)
        {
            storage[next++] = obj;
        }
        else
        {
            //make copy and create new with size+1
            Object[] oldstorage = storage;
            storage = new Object[size++];
            int i = 0;
            for (Object elm: oldstorage ) {
                storage[i] = elm;
                i++;
            }
            storage[next++] = obj;
        }


    }
    public T get(int index)
    {
        if(index >= 0 && index < next)
        {
            return (T)storage[index];
        }
        else
            throw new IndexOutOfBoundsException("Out");

    }



    String getAll()//Если я првильно понял задание то так
    {
        String ans = new String();
        for(int i =0;i<next;i++)
        {
            ans += ((T)storage[i]).toString();
        }
        return ans;

    }
    public void update(int index, T obj)
    {
        if(index < size && index >= 0)
        {
            storage[index] = obj;
        }
        else
            throw new IndexOutOfBoundsException("Out");
    }

    public void delete(int index)
    {
        if(index < size && index >= 0 && index < next)
        {
            Object[] oldstorage = storage;
            storage = new Object[size--];
            next--;
            int i = 0;
            for (Object elm: oldstorage ) {
                if(i != index) {
                    storage[i] = elm;
                    i++;
                }
            }
        }
        else
            throw new IndexOutOfBoundsException("Out");
    }
    public void delete(T obj)
    {
        boolean deleted =false;
        for (Object elm: storage) {
            if((obj).equals((T)elm)) //Находим
            {
                Object[] oldstorage = storage; //Копируем старое
                storage = new Object[size--]; //Создаем новое только поменьше
                next--;
                int i = 0;
                for (Object elmt: oldstorage ) {
                    if (!elm.equals(elmt)) {
                        storage[i] = elmt;
                        i++;
                    }
                }
                deleted = true;
            }
        }
        if (!deleted) throw new NoSuchElementException();
    }

    public int getSize()
    {
        return next;
    }
}
