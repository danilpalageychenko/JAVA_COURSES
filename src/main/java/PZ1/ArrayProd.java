package PZ1;

/**
 * Created by gaara on 12.07.16.
 */
public class ArrayProd {

    public static double Multiply(double mas[])
    {
        int mul = 1;
        for (double elm : mas)
        {
            mul*=elm;
        }
        return mul;
    }
}
