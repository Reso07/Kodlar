package JavaCourse;

import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class MySetup {

    private static Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Launcher launcher = new Launcher();
        boolean quit = false;
        instructions();
        launcher.addLesson(new Lesson("Language","Francis van der Hoeven","https://zoom.us/j/6720858464?pwd=VDZuMlducWhqZzVlcFFOWUZIcDg4dz09"));
        launcher.addLesson(new Lesson("Turkish","Esra Ferda Ürtekin","https://meet.google.com/jdf-hnik-ptb"));
        launcher.addLesson(new Lesson("PE","Gregory Pinto","https://us02web.zoom.us/j/137116972?pwd=dWFHMTNxUVVINkJDZTdoYTdtOUZqQT09"));
        launcher.addLesson(new Lesson("Computer Science","Mertuğrul","https://meet.google.com/orq-hfht-eng"));
        launcher.addLesson(new Lesson("Deutsch","Temel","https://zoom.us/j/97371531703?pwd=Z3FzVFNWbHRGak0xZVpkbGtsSUZadz09"));
        launcher.addLesson(new Lesson("Maths", "Marsha Copeland", "https://zoom.us/j/110237981?pwd=Sy9lZGpyMi9LVkh1ajJlVVpoNVJoUT09"));
        launcher.addLesson(new Lesson("Creative Arts","Celeste Pierson","https://zoom.us/j/92849126083?pwd=UFlkOTlDMVN2TzhHNXh0R1NxemYzQT09"));
        while (!quit) {
            System.out.print("Enter action: "); int action = scanner.nextInt(); scanner.nextLine();
            switch (action) {
                case 1:
                    launcher.launch();
                    break;
                case 2:
                    instructions(); break;
                case 3:
                    launcher.print(); break;
                case 4:
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
                "\n1 - Launch meeting"+
                "\n2 - Instructions"+
                "\n3 - View class information"+
                "\n4 - Quit");
    }
}
