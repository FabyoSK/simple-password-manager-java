package com.fabyosk;
/*
 * by FabyoSK @
 */

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        FileManager manager = new FileManager("passwords.txt");

        manager.addPassword("FSK-is-love_FSK-is-life");
        manager.addPassword("IsThatAPassword?");
        manager.addPassword("LOLIXPO");
        manager.addPassword("ZshX");
        manager.addPassword("ThousandSunny1000");

        manager.toTerminal();

    }
}
