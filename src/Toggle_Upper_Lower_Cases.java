

import java.util.Scanner;

import static java.lang.Character.*;

public class Toggle_Upper_Lower_Cases {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println(toggle(name));

    }

    private static String toggle(String string) {
        String ans = "";

        for (int i = 0; i < string.length(); i++)
            if (isUpperCase(string.charAt(i))) {
                ans = String.format("%s%s", ans, toLowerCase(string.charAt(i)));
            } else {
                ans = String.format("%s%s", ans, toUpperCase(string.charAt(i)));
            }

        return ans;

    }
}
