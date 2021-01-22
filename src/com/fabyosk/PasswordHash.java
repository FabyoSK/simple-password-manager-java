package com.fabyosk;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PasswordHash {
    private String secret = "fsksssss";
    private String password = "ILoveJava";


    String myIpValue = "192.168.0.1";
public PasswordHash(){

}
    public void encrygpt(String string) {
        String seed = "ipNumber";
        String myIpValue = "192.168.0.1";

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(seed);
        String encrypted= encryptor.encrypt(myIpValue);

        System.out.println(encrypted);

    }
    public String encrypt(String str){
        int code;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            code = Math.round((float) Math.random()*8+1);
            result += code + Integer.toHexString( ((int) str.charAt(i) ) ^ code )+"-";
        }
        return result.substring(0, result.lastIndexOf("-"));
    }

    public String decrypt(String str){
        str = str.replace("-", "");
        String result = "";
        for (int i = 0; i < str.length(); i+=3) {
            String hex =  str.substring(i+1, i+3);
            result += (char) (Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));
        }
        return result;
    }


}
