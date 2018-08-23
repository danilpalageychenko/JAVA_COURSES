package HomeWork4.Task4_1;


/**
 * Created by gaara on 4/24/17.
 */
public class App {

    public static void main(String[] args) {

        Car[] car = {new Car("BMV", 1000), new Car("Mazda", 183), new Car("Opel", 9843), new Car("Vaz2109", 256), new Car("Priora", 2119)};
        Computer[] comp = {new Computer("Intel", 100), new Computer("Amd", 50), new Computer("IBM", 4000), new Computer("Apple", 300), new Computer("HP", 30)};
        Integer[] integer = {11, 2, 76, 4, 42, 23, 54};
        String[] string = {"qwerty", "qwe1", "qwe2", "qwe3", "qwe4"};

        System.out.println(max(integer));
        System.out.println(max(comp));
        System.out.println(max(string));
        //Error
        //System.out.println(max(car));
    }

    public static Comparable max(Comparable [] input)
    {
        Comparable output = input[0];
        for (int i = 1; i < input.length; i ++) {
            for (int j = i; j < input.length; j ++) {
                output = output.compareTo(input[j]) > 0? output : input[j];
            }
        }
        return output;
    }




    }

