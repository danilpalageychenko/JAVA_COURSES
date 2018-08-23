package PZ1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaara on 12.07.16.
 */
public class Student {


    public static class Group
    {
        int course;
        String facult;

        public Group(int course, String facult)
        {
            setCourse(course);
            setFacult(facult);
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            if(course <0 || course >5)
                throw new IndexOutOfBoundsException("Course too small or hight");
            this.course = course;
        }

        public String getFacult() {
            return facult;
        }

        public void setFacult(String facult) {
            this.facult = facult;
        }


    }
    public static class Exam
    {
        String subject;
        int mark;
        int tryYear;
        int trySemestr;

        public Exam(String subject, int mark, int tryYear, int trySemestr) {
            setSubject(subject);
            setMark(mark);
            setTryYear(tryYear);
            setTrySemestr(trySemestr);
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            if(mark < 0 || mark > 100) throw new IndexOutOfBoundsException("mark too low or too hi");
            this.mark = mark;
        }

        public int getTryYear() {
            return tryYear;
        }

        public void setTryYear(int tryYear) {
            if(tryYear > LocalDateTime.now().getYear() || tryYear < 0) throw new IndexOutOfBoundsException("tryYear too low or too hi");
            this.tryYear = tryYear;
        }

        public int getTrySemestr() {
            return trySemestr;
        }

        public void setTrySemestr(int trySemestr) {
            if(trySemestr > 2 | trySemestr < 1) throw new IndexOutOfBoundsException("trySemestr too low or too hi");
            this.trySemestr = trySemestr;
        }
    }

    String name;
    String surName;
    Group group;
    List<Exam> exmas;

    public Student(String name,String surName,Group group,Exam...exams)
    {
        setName(name);
        setSurName(surName);
        setGroup(group);
        ArrayList<Exam> tmpList = new ArrayList<>();
        for (Exam elm: exams)
        {
            tmpList.add(elm);
        }
        setExmas(tmpList);
    }

    public int higestMark()
    {

        try {
            int hm = 0;
            for (Exam elm : exmas) {
                if (hm < elm.getMark())
                    hm = elm.getMark();
            }
            return hm;
        }
        catch (NullPointerException e)
        {
            return 0;
        }
    }
    public void addExam(String subject,int mark,int tryYear,int trySemestr)
    {
        exmas.add(new Exam(subject,mark,tryYear,trySemestr));
    }
    public void removeExam(String subject) throws NullPointerException
    {
        for (Exam elm : exmas)
        {
            if(elm.getSubject().equals(subject))
            {
                exmas.remove(elm);
                return;
            }
        }
        throw new NullPointerException(subject + " does not exist in student");
    }
    public int numberOfExamsWithMark(int mark)
    {
        int count = 0;
        for (Exam elm : exmas)
        {
            if (elm.getMark() == mark)
                count++;
        }
        return count;
    }
    public int averageSemestrMark(int semestr)
    {
        int averMark = 0;
        for (Exam elm : exmas) {
            averMark+= elm.getMark();
        }

        return averMark/exmas.size();
    }
    protected boolean isPassExam(String subject)
    {
        for (Exam elm : exmas) {
            if(elm.getSubject() == subject)
                return true;
        }
     return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setExmas(List<Exam> exmas) {
        this.exmas = exmas;
    }
}
