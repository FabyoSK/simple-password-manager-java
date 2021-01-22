package com.fabyosk;

import java.io.*;

public class FileManager {
    private String file;
    private PasswordHash passwordHash = new PasswordHash();

    public FileManager(String file) {
        this.file = file;
    }

    public void addPassword(String pass) throws IOException {

        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }
        bReader.close();
        result += passwordHash.encrypt(pass);
        result = result.trim();

        FileWriter writer = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(writer);

        bWriter.write(result);
        bWriter.flush();
        bWriter.close();
    }

    public void toTerminal() throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        while ((line = bReader.readLine()) != null) {
            result += passwordHash.decrypt(line) + "\n";

        }
        result = result.trim();
        System.out.println(result);
        bReader.close();

    }
}
