package PZ4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by gaara on 19.08.16.
 */
public class StudentUtilsTest {


    ArrayList<Student> studentList;
    @Before
    public void setUp() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student("FirstName4","LasName4",2));
        studentList.add(new Student("FirstName5","LasName5",3));
        studentList.add(new Student("FirstName6","LasName6",3));
        studentList.add(new Student("FirstName1","LasName1",1));
        studentList.add(new Student("FirstName2","LasName2",1));
        studentList.add(new Student("FirstName3","LasName3",2));

    }
    @Test
    public void createMapFromList() throws Exception {

        Map<String,Student> studentMap = StudentUtils.createMapFromList(studentList);
        System.out.println(studentMap.get("FirstName2 LasName2").getFirstName());

    }

    @Test
    public void printStudents() throws Exception {
        StudentUtils.printStudents(studentList,2);
    }

    @Test
    public void sortStudent() throws Exception {
        ArrayList<Student> tempStList = new ArrayList<Student>(StudentUtils.sortStudent(studentList));
        for (Student std:tempStList)
        {
            System.out.println(std.getFirstName() + " " + std.getLastName() + " " + std.getCourse());
        }
    }

}