package PZ1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaara on 12.07.16.
 */
public class ArrayProdTest {
    double in[] = {1,2,3,4,5,6,7};

    @Test
    public void multiply() throws Exception {
        double actual = ArrayProd.Multiply(in);
        double expected = 5040;
        double delta = 0.001;
        assertEquals(expected,actual,delta);
    }

}