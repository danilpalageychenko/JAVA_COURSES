package PZ1;

import java.sql.Array;

/**
 * Created by gaara on 12.07.16.
 */
public class ArraySum {


    double maselm[];
    ArraySum(double[] mas)
    {
     setSum(mas);
    }
    public double Sum()
    {
        int sum = 0;
        for (double elm : maselm)
        {
            sum+=elm;
        }
        return sum;
    }
    public static double Sum(double[] mas) throws NullPointerException
    {
        if(mas == null) throw new NullPointerException("Argument is null");
        int sum = 0;
        for (double elm : mas)
        {
            sum+=elm;
        }
       return sum;
    }
    public void setSum(double[] mas) {
        this.maselm = mas;
    }
}
