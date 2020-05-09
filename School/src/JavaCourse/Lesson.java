package JavaCourse;

import java.util.Scanner;

public class Lesson {
    private String name;
    private Staff teacher;
    private int grade;
    private Scanner scanner = new Scanner(System.in);

    public void addTeacher(Staff teacher) {
        this.teacher = teacher;
    }

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setGrade(String name) {
        if(name==null) {
            System.out.print("Student name: "); name = scanner.nextLine();
        }
        if(School.findStudent(name)!=null) {
            System.out.print("Enter the grade over 100: ");
            grade = scanner.nextInt();
        }
    }

    public int getGrade() { return grade; }
}
