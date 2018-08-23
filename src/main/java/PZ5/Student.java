package PZ5;

import java.io.Serializable;

/**
 * Created by gaara on 01.09.16.
 */
public class Student implements Serializable{
    String name;
    String surName;
    int mark;

    public Student(String name, String surName, int mark) {
        this.name = name;
        this.surName = surName;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
