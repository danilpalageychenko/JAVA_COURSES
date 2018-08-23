package HomeWork1;

/*
Создать объект класса Date, используя вложенные классы Год, Месяц, День. Методы:
задать дату, вывести на консоль день недели по заданной дате. День недели представить
в виде перечислення. Рассчитать количество дней, в заданном временном промежутке.
Т.е. в классе Date реализовать следующее:
public Date(int day, int month, int year)
public DayOfWeek getDayOfWeek()
public int getDayOfYear()
public int daysBetween(Date date)
В классе Year должна осуществляться проверка на високостность (можно реализовать в конструкторе)
в результате, установить значение для соотв. атрибута года.
В классе Month можно сделать метод который позволит узнать количество дней для того или
иного месяца [1-12]. Метод можно использовать для подсчета дней в других методах.
public int getDays(int monthNumber, boolean leapYear)
Перечисление должно иметь конструктор с параметром, для того чтобы задать
индексы дней недели [0-6]. 0 – Понедельник.
Так же можно создать статический метод
public static DayOfWeek valueOf (int index)
Для того чтобы можно было после математических расчетов использовать данный метод
для преобразования индекса дня недели в соотв. элемент перечисления.
При желании можно сделать собственную архитектуру для решения поставленной задачи.
Главное продемонстрировать в решении использование вложенных классов и перечисления.

Анонимные классы.

Создайте класс автомобиль. Создайте 2 объекта этого класса.
При создании каждого из объектов класса автомобиль переопределите
методы toString() и equals() c помощью анонимных классов, что б вывод
 toString() был различным для каждого из объектов. Продемонстрируйте,
 работу переопределенных методов.
*/



/**
 * Created by gaara on 11.07.16.
 */
public class App {
    public static void main(String[] args) {
        Date date = new Date(11,7,2016);
        System.out.println("Day = " + date.getDay());
        System.out.println("Month = " + date.getMonth());
        System.out.println("Year = " + date.getYear());

        System.out.println("Is year leap = " + date.isLeap());
        System.out.println("Day of week = " + date.getDayOfWeek());
        System.out.println("Day of year = " + date.getDayOfYear());
        System.out.println("Days between 11.07.2016 and 21.07.2016 = " + date.daysBetween(new Date(21,7,2016)));

        System.out.println("-------------------------------------------");

        Automobile autom1 = new Automobile(){
            String name = "CAR";
            double length = 3.1;

            @Override
            public String toString()
            {
                return "Name = " + name + "\nLength = " + length;
            }

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }
        };

        Automobile autom2 = new Automobile(){
            String name = "SuperCar";
            String model = "G310";

            @Override
            public String toString()
            {
                return "Car name = " + name + model;
            }

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }
        };

        System.out.println(autom1.toString());
        System.out.println("~~~~");
        System.out.println(autom2.toString());

    }
}
