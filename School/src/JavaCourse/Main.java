// This app is an admin database rather than a user interface where people log into accounts. The admin manages the school, accounts,
// etc. using this
package JavaCourse;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Account> accountList = new ArrayList<>();
    private static LocalDateTime now = LocalDateTime.now();
    private static School school = new School("Robert College");

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(now));
        boolean quit = false;
        instructions1();
        while(!quit) {
            checkStudents();
            System.out.println("Enter action: "); int action = scanner.nextInt(); scanner.nextLine();
            switch(action) {
                case 0:
                    instructions1(); break;
                case 1:
                    System.out.print("Status: "); String status = scanner.nextLine().toLowerCase();
                    System.out.println("Enter a numerical password of 8 characters: ");
                    int password = scanner.nextInt();
                    if(status.equals("student")) {
                        accountList.add(new Account(school.registerStudent(),password));
                    } else {
                        accountList.add(new Account(school.recruitStaff(status),password));
                    break;
                case 2:
                    instructions2(); quit = true; break;
            }
        }
        quit = false;
        instructions2();
        while(!quit) {
            checkStudents();
            System.out.println("Enter action: "); int action = scanner.nextInt();
            switch (action) {
                case 0:
                    instructions2(); break;
                case 1:
                    school.registerStudent(); break;
                case 2:
                    System.out.print("Status: "); String status = scanner.nextLine();
                    school.recruitStaff(status); break;
                case 3:
                    school.viewStudents(); break;
                case 4:
                    school.grade(); break;
                case 5:
                    school.dispel(null); break;
                case 6:
                    for(Account a:accountList) {
                        a.storePassword();
                    }
                    break;
                case 7:
                    school.giveRaise(); break;
                case 8:
                    quit = true; break;
            }
        }
    }
        
    private static void checkStudents() {
            for(Student s: School.getStudents) {
                if(now.getYear()>=s.getYear() && now.getMonthValue()>=7) {
                    System.out.println(s.getName()+""+s.getSurname()+" graduated.");
                    school.dispel(s.getName());
                }
            }
    }

    private static boolean findAccount(Account account) {
        if(accountList.contains(account)) {
            return true;
        }
        return false;
    }

    private static void instructions1() {
        System.out.println("INSTRUCTIONS"+
                "\n0 - Instructions"+
                "\n1 - Login"+
                "\n2 - Create account"+
                "\n3 - Quit");
    }

    private static void instructions2() {
        System.out.println("INSTRUCTIONS"+
                "\n0 - Instructions"+
                "\n1 - Register a student"+
                "\n2 - Recruit staff"+
                "\n3 - View students"+
                "\n4 - Add grade to a student"+
                "\n5 - Dispel a student or a staff member"+
                "\n6 - All accounts"+
                "\n7 - Give raise to a staff member"+
                "\n8 - Quit");
    }
}
final class Account {
    private static final int key = 24242424;
    private final int encryptedPassword;
    private final String name;


    public Account(String name, int password) {
        this.name = name; this.encryptedPassword = encrypt(password);
    }

    private int encrypt(int password) {
        return password^key;
    }

    public final void storePassword() {
        System.out.println("Storing your password as " + encryptedPassword);
    }
    
// This function is currently not used. Further improvements will involve the usage of this function
    public boolean login(int password) {
        if(encrypt(password) == this.encryptedPassword) {
            System.out.println("Successfully logged into " + password);
            return true;
        } else {
            System.out.println("Login not granted.");
            return false;
        }
    }
}
