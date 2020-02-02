package common.tcs;

import java.util.Scanner;

public class TCS_NUMBER_SORT_SPELL {

    private static final String[] units = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
    private static final String[] tens = {
            "",          // 0
            "",          // 1
            "Twenty",    // 2
            "Thirty",    // 3
            "Forty",     // 4
            "Fifty",     // 5
            "Sixty",     // 6
            "Seventy",   // 7
            "Eighty",    // 8
            "Ninety"     // 9
    };
    private static String[][] numb = new String[2][4];
    private static Scanner scanner = new Scanner(System.in);
    private static String outOfBounds="Out of bounds";

    public static void main(String[] args) {
        String a = scanner.next(), b = scanner.next();
        if(Integer.parseInt(a)<0 || Integer.parseInt(b)<0){
            System.out.print(outOfBounds);
        }
        String ans = numberSortSpell(a, b);
        System.out.print(ans);
    }

    private static String numberSortSpell(String a, String b) {
        int n1 = Integer.parseInt(a), n2 = Integer.parseInt(b);

        int LIMIT = 99999;
        if (n1 > LIMIT || n2 > LIMIT)
            return outOfBounds;

        if (a.equals(b))
            return a;

        if (n1 < n2) {
            numb[0][0] = a;
            numb[1][0] = b;
            numb[0][1] = convert(n1);
            numb[1][1] = convert(n2);
        } else {
            numb[0][0] = b;
            numb[1][0] = a;
            numb[0][1] = convert(n2);
            numb[1][1] = convert(n1);
        }
        if(numb[0][1].compareTo(numb[1][1])<0){
            numb[0][2] = numb[0][1];
            numb[1][2] = numb[1][1];
            numb[0][3] = numb[0][0];
            numb[1][3] = numb[1][0];

        } else {
            numb[0][2] = numb[1][1];
            numb[1][2] = numb[0][1];
            numb[0][3] = numb[1][0];
            numb[1][3] = numb[0][0];
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(numb[i][j] + "\t\t");
            }
            System.out.println();
        }
        n1 = Integer.parseInt(numb[0][0]) + Integer.parseInt(numb[0][3]);
        n2 = Integer.parseInt(numb[1][0]) + Integer.parseInt(numb[1][3]);

        a = "" + n1;
        b = "" + n2;
        System.out.println(n1 + " " + n2);
        return numberSortSpell(a, b);
    }

    private static String convert(final int n) {
        if (n < 0) {
            return "Minus " + convert(-n);
        }
        if (n < 20) {
            return units[n];
        }
        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }
        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }
        if (n < 100000) {
            return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
        }
        if (n < 10000000) {
            return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
        }
        return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }
}
