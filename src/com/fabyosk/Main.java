package com.fabyosk;
/*
 * by FabyoSK @
 */

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== Welcome to the FSK Locker! ===");
        boot();
    }

    private static void boot() throws IOException {
        FileManager manager = new FileManager();
        boolean end = false;
        String decor = "====> ";
        Scanner in = new Scanner(System.in);
        while (!end) {
            System.out.println(decor + "1 - Create a user");
            System.out.println(decor + "2 - Login to a existing user");
            System.out.println(decor + "0 - Quit");
            System.out.print(decor + "Type your choice: ");
            switch (in.nextInt()) {
                case 1:
                    System.out.print("Username: ");
                    Scanner userName = new Scanner(System.in);
                    String user = userName.next().trim();

                    System.out.print("Password: ");
                    Scanner password = new Scanner(System.in);
                    String pass = password.next().trim();

                    manager.createUser(user, pass);

                    break;
                case 2:
                    System.out.print("User name: ");
                    Scanner userNameLogin = new Scanner(System.in);
                    String userLogin = userNameLogin.next().trim();

                    System.out.print("Password: ");
                    Scanner passwordLogin = new Scanner(System.in);
                    String passLogin = passwordLogin.next().trim();

                    if (manager.login(userLogin, passLogin)) {
                        System.out.println("Succesfully login");
                        menu(userLogin);
                    } else {
                        System.out.println("ERROR: wrong Username or password");
                    }

                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 0:
                    System.out.println("\n=== Thanks for using FSK Locker ===");
                    System.out.println("Have a nice day :)");
                    end = true;
                    break;
            }
        }
    }

    private static void menu(String user) throws IOException {

        FileManager manager = new FileManager(user);
        System.out.println("Hello, " + user);
        boolean end = false;
        String decor = "====> ";
        while (!end) {
            System.out.println(decor + "1 - ADD New password");
            System.out.println(decor + "2 - List saved passwords");
            System.out.println(decor + "0 - Logout");
            System.out.print(decor + "Type your choice: ");
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1:
                    System.out.print("Type a new password to add: ");
                    Scanner password = new Scanner(System.in);
                    manager.addPassword(user, password.next());
                    System.out.println("Password added succesfully\n");
                    break;
                case 2:
                    System.out.println("List of saved passwords:");
                    manager.toTerminal();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Going back...\n");
                    boot();
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 0:
                    System.out.println("\n=== Thanks for using FSK Locker ===");
                    System.out.println("Have a nice day :)");
                    end = true;
                    break;
            }
        }
    }
}
