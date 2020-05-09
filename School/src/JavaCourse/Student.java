package JavaCourse;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Student implements Comparable<Student> {
    private String name, surname;
    private int year;
    private List<Lesson> lessons = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public Student(String name, String surname, int year) {
        this.name = name; this.surname = surname; this.year = year;
    }

    public void addLesson() {
        System.out.println("Enter lesson name: "); String lessonName = scanner.nextLine();
        if(School.findClass(lessonName)!=null && myLesson(lessonName)==null) {
            lessons.add(School.findClass(lessonName));
        } else if(myLesson(lessonName) != null ){
            System.out.println("You are already taking "+lessonName);
        } else {
            System.out.println(lessonName + " not found on school's database.");
        }
    }

    private Lesson myLesson(String name) {
        for(Lesson l: lessons) {
            if(l.getName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    public double getGPA() {
        double gpa = 0, count = 0;
        for(Lesson l: lessons) {
            gpa += l.getGrade(); count++;
        }
        return gpa/count;
    }

    public int getYear() { return year; }
    public String getName() { return name; }
    public String getSurname() { return surname; }

    @Override
    public int compareTo(Student o) {
        if(o.getGPA()>getGPA()) {
            return 1;
        } else if(o.getGPA()==getGPA()) {
            return 0;
        }
        return -1;
    }

    public void grade(String classname) {
        if(School.findClass(classname)!=null && myLesson(classname)!=null) {
            myLesson(classname).setGrade(name);
        }
    }
}
