package com.fabyosk;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        FileManager f = new FileManager("passwords.txt");
        f.addPassword("Something");

        PasswordHash passwordHash = new PasswordHash();

        String a = passwordHash.encrypt("something");
        System.out.println(a);
        String b = passwordHash.decrypt(a);
        System.out.println(b);

    }
}
