package HomeWork3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaara on 16.08.16.
 */
public class GenericStorageTest {

    GenericStorage<String> gs;

    @Test
    public void add() throws Exception {
        //1
        gs = new GenericStorage<String>();
        gs.add("Game");
        String actual = gs.get(0);
        String expected = "Game";

        assertEquals(expected,actual);
        //2
        gs = new GenericStorage<String>(1);
        gs.add("Game");
        actual = gs.get(0);
        expected = "Game";

        assertEquals(expected,actual);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() throws Exception {
        //1
        gs = new GenericStorage<String>(1);
        gs.get(0);

        //2
        gs = new GenericStorage<String>(1);
        gs.add("Game");
        gs.get(1);
    }

    @Test
    public void getAll() throws Exception {
        gs = new GenericStorage<String>();

        gs.add("String 1");
        gs.add("String 2");
        gs.add("String 3");
        gs.add("String 4");

        String expected = new String("String 1String 2String 3String 4");
        String actual = gs.getAll();

        assertEquals(expected,actual);
    }

    @Test
    public void update() throws Exception {
        GenericStorage<Integer> gsInt = new GenericStorage<Integer>();

        gsInt.add(5);
        gsInt.add(7);
        gsInt.add(8);

        int expected = 10;
        gsInt.update(1,10);
        int actual = gsInt.get(1);

        assertEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteIndex() throws Exception {
        gs = new GenericStorage<String>(5);

        gs.add("String 1");
        gs.add("String 2");
        gs.add("String 3");
        gs.add("String 4");

        gs.delete(3);
        gs.get(3);
    }

    @Test
    public void deleteElem() throws Exception {
        gs = new GenericStorage<String>(5);

        gs.add("String 1");
        gs.add("String 2");
        gs.add("String 3");
        gs.add("String 4");

        gs.delete("String 3");

        String expected = "String 4";
        String actual = gs.get(2);

        assertEquals(expected,actual);
    }

    @Test
    public void getSize() throws Exception {
        gs = new GenericStorage<String>();
        int expected = 0;
        int actual = gs.getSize();

        assertEquals(expected,actual);

    }


}