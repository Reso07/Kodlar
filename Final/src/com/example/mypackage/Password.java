package com.example.mypackage;

public final class Password {
    private static final int key = 27389492;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encrypt(password);
    }

    private int encrypt(int password) {
        return password^key;
    }

    public final void storePassword() {
        System.out.println("Storing your password as " + encryptedPassword);
    }

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
