package PZ5;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by gaara on 01.09.16.
 */
public class AppTest {
    @Test
    public void notBufferWrite() throws Exception {
        System.out.println("Buffer Write");
        File file = new File("swapWordsPZ5.txt");
        App.bufferWrite(file);
    }

    @Test
    public void bufferWrite() throws Exception {
        System.out.println("Buffer Write");
        File file = new File("swapWordsPZ5.txt");
        App.notBufferWrite(file);
    }

}