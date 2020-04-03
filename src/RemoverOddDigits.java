package common;

import java.util.Scanner;

public class RemoverOddDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder n = new StringBuilder(s.next());
        int l = n.length(), temp;
        for (int i = 0; i < n.length(); i++) {
            temp = Character.getNumericValue(n.charAt(i));
            if (temp % 2 != 0 || temp == 0) {
                n.deleteCharAt(i);
                i--;
            }
        }
        if (n.length() == l) {
            System.out.println("-1");
        } else {
            System.out.println(n);
        }
    }
}
