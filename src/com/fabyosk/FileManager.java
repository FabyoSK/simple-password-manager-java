package com.fabyosk;

import java.io.*;

public class FileManager {
    private String usersfile = "users.txt";
    private PasswordHash passwordHash = new PasswordHash();
    private String currentUser;

    public FileManager() {
    }

    public FileManager(String currentUser) {
        this.currentUser = currentUser;
    }

    public void addPassword(String user, String pass) throws IOException {

        FileReader reader = new FileReader(user + "-passwords.txt");
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

        FileWriter writer = new FileWriter(user + "-passwords.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);

        bWriter.write(result);
        bWriter.flush();
        bWriter.close();
    }

    public void toTerminal() throws IOException {
        FileReader reader = new FileReader(currentUser+"-passwords.txt");
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

    public void createUser(String user, String pass) throws IOException {
        FileReader reader = new FileReader(usersfile);
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }
        bReader.close();
        result += user + ":" + pass;
        result = result.trim();

        FileWriter writer = new FileWriter("users.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);

        FileWriter userPass = new FileWriter(user + "-passwords.txt");
        userPass.write(0);
        userPass.close();
        bWriter.write(result);
        bWriter.flush();
        bWriter.close();
    }


    public boolean login(String user, String pass) throws IOException {
        FileReader reader = new FileReader(usersfile);
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            String[] credencials = line.split(":");
            if (credencials[0].equals(user) && credencials[1].equals(pass)) {
                bReader.close();
                return true;
            }

        }
        bReader.close();
        return false;
    }
}
