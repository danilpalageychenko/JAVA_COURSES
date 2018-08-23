package PZ1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaara on 12.07.16.
 */
public class ArraySumTest {

    double in[] = {1,2,3,4,5,6,7};
    ArraySum as = new ArraySum(in);
    @Test
    public void sumNoParameters() throws Exception {



        double actual = as.Sum();
        double expected = 28;
        double delta = 0.001;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void sum() throws Exception {
        double actual = ArraySum.Sum(in);
        double expected = 28;
        double delta = 0.001;
        assertEquals(expected,actual,delta);
    }

    @Test(expected = NullPointerException.class)
    public void sumGoNull() throws Exception {
        ArraySum.Sum(null);
    }


}