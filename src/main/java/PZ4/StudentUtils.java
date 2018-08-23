package PZ4;

import java.util.*;

/**
 * Created by gaara on 19.08.16.
 */
public class StudentUtils {
    public static Map<String, Student> createMapFromList(List<Student> students)
    {
        HashMap<String,Student> result = new HashMap<String, Student>();

        for (Student std: students) {
            result.put(std.getFirstName()+" "+ std.getLastName(),std);
        }
        return result;

    }

    public static void printStudents(List<Student> students, int course){
        ListIterator<Student> studIter = students.listIterator();
        while(studIter.hasNext())
        {
            Student thisStud;
            if((thisStud = studIter.next()).getCourse() == course)
                System.out.println(thisStud.getFirstName() + " " + thisStud.getLastName() + " " + thisStud.getCourse());
        }
    }
    public static List<Student> sortStudent(List students)
    {
        ArrayList<Student> result = new ArrayList<Student>(students);
        result.sort((s1, s2) -> s1.firstName.compareTo(s2.firstName) );
        return result;
    }


}
