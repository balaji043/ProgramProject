package common.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SHA_Secure_Hash_Algrithm {
    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter string:");
        String rawString = userInput.readLine();

        /*try {
           /System.out.println("SHA1 hash of string: " + AeSimpleSHA1.SHA1(rawString));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
