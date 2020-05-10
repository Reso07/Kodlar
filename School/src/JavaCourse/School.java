package JavaCourse;

import java.util.*;

public class School {
    public static List<Lesson> allClasses = new Vector<>();
    protected static List<Student> students = new Vector<>();
    private static List<Staff> staff = new Vector<>();
    private Scanner scanner = new Scanner(System.in);
    private final String name;

    public School(String name) {
        this.name = name;
    }

    public String registerStudent() {
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Surname: "); String surname = scanner.nextLine();
        System.out.print("Year: "); int year = scanner.nextInt(); scanner.nextLine();
        if(findStudent(name)==null) {
            students.add(new Student(name, surname, year));
            System.out.println("Successfully registered "+name+" "+surname+" to the school.");
        } else {
            System.out.println(name + " is already registered.");
        }
        return name;
    }

    public static Student findStudent(String name) {
        for(Student s: students) {
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void newClass() {
        System.out.print("Enter class name: "); String classname = scanner.nextLine();
        System.out.print("Enter teacher name: "); String teacher = scanner.nextLine();
        if(findTeacher(teacher)!=null) {
            allClasses.add(new Lesson(classname));
        }
    }

    private Staff findTeacher(String name) {
        for(Staff s:staff) {
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public static Lesson findClass(String name) {
        for(Lesson l : allClasses) {
            if(l.getName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    protected String recruitStaff(String status) {
        System.out.print("Enter name: "); String name = scanner.nextLine();
        System.out.print("Enter surname: "); String surname = scanner.nextLine();
        System.out.println("Salary: "); int salary = scanner.nextInt(); scanner.nextLine();
        if(findTeacher(name)==null) {
            Staff newstaff = new Staff(status,name,surname);
            newstaff.setSalary(salary);
            staff.add(newstaff);
        }
        return name;
    }

    public void viewStudents() {
        Collections.sort(students);
        for(Student s: students) {
            System.out.println(s.getName() + "" + s.getSurname() + " - YEAR: "+s.getYear()+" - GPA: "+s.getGPA());
        }
    }

    public void dispel(String name1) {
        if(name1==null) {
            System.out.println("Enter name: ");
            name1 = scanner.nextLine();
            System.out.println("Surname: ");
            String surname = scanner.nextLine();
        }
        if(findStudent(name1)!=null) {
            students.remove(findStudent(name1));
        } else if(findTeacher(name1)!=null) {
            staff.remove(findTeacher(name1));
        }
    }

    public void grade() {
        System.out.println("Enter class name: "); String classname = scanner.nextLine();
        System.out.println("Enter student name: "); String student = scanner.nextLine();
        if(findClass(classname)!=null && findStudent(student)!=null) {
            findStudent(student).grade(classname);
        } else {
            System.out.println("ERROR");
        }
    }
    
    protected void giveRaise() {
        System.out.print("Enter teacher name: "); String name = scanner.nextLine();
        System.out.print("Enter raise amount: "); long amount = scanner.nextLong(); scanner.nextLine();
        if(findTeacher(name)!=null) {
            findTeacher(name).setSalary(findTeacher(name).getSalary()+amount);
        } else {
            System.out.println("Staff member not found.");
    }
}
