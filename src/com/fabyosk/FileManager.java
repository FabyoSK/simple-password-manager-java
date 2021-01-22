package com.fabyosk;

import java.io.*;

public class FileManager {
    private String file;
    private PasswordHash passwordHash = new PasswordHash();

    public FileManager(String file) {
        this.file = file;
    }

    public String addPassword(String pass) throws IOException, IOException {

        // create a new file reader
        FileReader reader = new FileReader(file);

        // wrap the file reader using a buffered reader
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }
        bReader.close();
        result += passwordHash.encrypt(pass);

        // create a new file writer
        FileWriter writer = new FileWriter(file);

        // wrap the file writer using a buffered writer
        BufferedWriter bWriter = new BufferedWriter(writer);

        //add text to buffer
        bWriter.write(result);

        bWriter.flush(); // if the buffer is not full, flush will force disk write
        bWriter.close();


        return result;
    }
    public void toTerminal() throws IOException {
        // create a new file reader
        FileReader reader = new FileReader(file);

        // wrap the file reader using a buffered reader
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            result += passwordHash.decrypt(line) + "\n";

        }System.out.println(result);
        bReader.close();

    }
}
