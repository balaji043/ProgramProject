package common;

import java.util.Scanner;

public class UserIdGeneration {
    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);

        String f_name = S.next(),
                l_name = S.next(),
                pin = S.next(),
                b_name,
                s_name,
                Final;

        int     n = S.nextInt(),
                fl=f_name.length(),
                ll=l_name.length();

        if (fl>ll) {
            b_name = f_name;
            s_name = l_name;
        } else if (fl<ll) {
            b_name = l_name;
            s_name = f_name;
        } else {
            int c = f_name.compareTo(l_name);
            if (c < 0) {
                s_name = f_name;
                b_name = l_name;
            } else {
                s_name = l_name;
                b_name = f_name;
            }
        }
        Final = b_name.charAt(0) + s_name + pin.charAt(n - 1) + pin.charAt(pin.length() - n);
        StringBuffer sb = new StringBuffer(Final);
        convertOpposite(sb);
    }

    private static void convertOpposite(StringBuffer str) {
        int ln = str.length();
        for (int i = 0; i < ln; i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c))
                str.replace(i, i + 1, Character.toUpperCase(c) + "");
            else
                str.replace(i, i + 1, Character.toLowerCase(c) + "");
        }
        System.out.println(str);
    }

}
