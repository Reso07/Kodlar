package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        int pw = 12345678;
        Password password = new Password(pw);
        password.storePassword();
        password.login(4356778);
        password.login(-5);
        password.login(12345678);
        System.out.println("*******************************");
        SIBTest sibTest = new SIBTest();
        System.out.println(sibTest.getOwner());
    }
}
