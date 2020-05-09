package com.example.mypackage;

public class SIBTest {
    private static final String owner;

    static {
        owner = "Reşit";
        System.out.println("Static initializer one called.");
    }

    public SIBTest() {
        System.out.println("Constructor called.");
    }

    static {
        System.out.println("Second static initialized called.");
    }

    public String getOwner() {
        return owner;
    }
}
