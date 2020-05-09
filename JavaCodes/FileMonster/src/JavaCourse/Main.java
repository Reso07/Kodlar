package JavaCourse;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        desktop.browse(new URI("www.google.com"));
        Launcher launcher = new Launcher();
        boolean quit = false;
        instructions();
        while(!quit) {
            System.out.println("Enter action: ");
            int action = scanner.nextInt();scanner.nextLine();
            switch (action) {
                case 1:
                    launcher.addLesson(null); break;
                case 2:
                    launcher.launch(); break;
                case 3:
                    instructions(); break;
                case 4:
                    launcher.print();
                    break;
                case 5:
                    quit = true;
                    desktop.browse(new URI("https://www.youtube.com/watch?v=G1IbRujko-A"));
                    break;
                default:
                    System.out.println("Command not found.");
            }
        }
    }

    private static void instructions() {
        System.out.println("Instructions:"+
                "\n1 - Add a class"+
                "\n2 - Launch meeting"+
                "\n3 - Instructions"+
                "\n4 - View class information"+
                "\n5 - Quit");
    }
}
class Lesson {
    private String lessonName, teacherName, url;

    public Lesson(String lessonName, String teacherName, String url) {
        this.lessonName = lessonName; this.teacherName = teacherName; this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getLessonName() {
        return lessonName;
    }
}
class Launcher {
    private ArrayList<Lesson> lessons = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    protected void addLesson(Lesson lesson) {
        if(lesson == null) {
            System.out.print("Enter class name: ");
            String Class = scanner.nextLine();
            System.out.print("Enter teacher name: ");
            String teacher = scanner.nextLine();
            System.out.print("Enter the url for the meeting: ");
            String url = scanner.nextLine();
            if (findLesson(Class) == null) {
                lessons.add(new Lesson(Class, teacher, url));
            } else {
                System.out.println(Class + " already exists.");
            }
        } else {
            if(findLesson(lesson.getLessonName())==null) {
                lessons.add(lesson);
            } else {
                System.out.println(lesson.getLessonName()+" already exists.");
            }
        }
    }

    private Lesson findLesson(String className) {
        for(Lesson l: lessons) {
            if(l.getLessonName().equals(className)) {
                return l;
            }
        }
        return null;
    }

    public void print() {
        for(Lesson l:lessons) {
            System.out.println((lessons.indexOf(l)+1)+" - "+l.getLessonName()+" : "+l.getTeacherName());
        }
    }

    public void launch() throws Exception {
        System.out.print("Enter the class name you want to enter:");
        String name = scanner.nextLine();
        if(findLesson(name)!=null) {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(findLesson(name).getUrl()));
        }
    }
}
