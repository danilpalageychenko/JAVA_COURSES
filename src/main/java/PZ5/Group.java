package PZ5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gaara on 01.09.16.
 */
public class Group implements Serializable{
    ArrayList<Student> list;

    public Group() {
        list = new ArrayList<Student>();
    }

    public void addS(Student st)
    {
        list.add(st);
    }
    public void remove(Student st)
    {
        list.remove(st);
    }
    public Student get(int index)
    {
        return list.get(index);
    }


}
