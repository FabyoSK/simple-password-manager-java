package com.fabyosk;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager f = new FileManager("passwords.txt");
        f.addPassword("Something");
    }
}
