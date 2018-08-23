package PZ1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaara on 12.07.16.
 */

public class StudentTest {

    Student student;
    @Before
    public void init()
    {
        student = new Student("Vasya","SuperSurName",new Student.Group(1,"TKVT"),new Student.Exam("Math",90,2016,1),new Student.Exam("Phisics",60,2016,1));
    }

    @Test
    public void higestMark() throws Exception {
        int actual = student.higestMark();
        int expected = 90;
        assertEquals(expected,actual);
    }

    @Test
    public void addExam() throws Exception {
        student.addExam("Programming",70,2016,1);
        assertTrue(student.isPassExam("Programming"));
    }

    @Test
    public void removeExam() throws Exception {
        assertTrue(student.isPassExam("Math"));
        student.removeExam("Math");
        assertFalse(student.isPassExam("Math"));
    }
    @Test(expected = NullPointerException.class)
    public void removeExamExeption() throws Exception {
        student.removeExam("Programming");
    }

    @Test
    public void numberOfExamsWithMark() throws Exception {
        int actual = student.numberOfExamsWithMark(60);
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void averageSemestrMark() throws Exception {
        int actual = student.averageSemestrMark(1);
        int expected = 75;
        assertEquals(expected,actual);
    }
    @Test
    public void isPassExamTrue() throws Exception {
        assertTrue(student.isPassExam("Math"));
    }
    @Test
    public void isPassExamFalse() throws Exception {
        assertFalse(student.isPassExam("Programming"));
    }

}