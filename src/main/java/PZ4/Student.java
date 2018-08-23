package PZ4;


/**
 * Created by gaara on 19.08.16.
 */
public class Student {
    String firstName;
    String lastName;
    int course;

    public Student(String firstName, String lastName, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCourse() {
        return course;
    }

}
