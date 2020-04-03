

import java.util.Scanner;

public class ThreeDigitNumberPrint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.next();
        char[] c = string.toCharArray();
        int j = 0, i;

        String[] ans = new String[c.length / 3];
        ans[0] = "";

        for (i = 0; i < c.length - 2; i++) {
            if (Character.isDigit(c[i])) {
                ans[j] = "";
                while ( i < c.length&&Character.isDigit(c[i]) ) {
                    ans[j] += c[i];
                    i++;
                }
                j++;
            }
        }
        if (ans[0].isEmpty()) {
            System.out.print("-1");
        } else {
            for (i = 0; i < j; i++) {
                if (ans[i].length() == 3) System.out.print(ans[i] + " ");
            }
        }
    }
}
