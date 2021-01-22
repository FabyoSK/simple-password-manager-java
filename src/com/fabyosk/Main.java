package com.fabyosk;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        FileManager f = new FileManager("passwords.txt");
        f.addPassword("Something");

        PasswordHash passwordHash = new PasswordHash();
        f.toTerminal();

    }
}
