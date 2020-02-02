package common.face;

import java.util.Scanner;

import static java.lang.Character.isDigit;

public class CharOccurrence {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(getCharOccurrence());
        System.out.println(FrequentCount());
        System.out.println(FrequentChar());
        expandAlphabetOccurrenceMain();
        System.out.println(N2_Occurrence_in_N1_Count());
    }

    private static int getCharOccurrence() {
        String s = scanner.next();
        char c = scanner.next().charAt(0);
        int n = scanner.nextInt(), l = s.length(), c1 = 0, c2 = 0, q = n / l, r = n % l;
        for (int i = 0; i < l; i++) {
            if (i < r && c == s.charAt(i)) c1++;
            if (c == s.charAt(i)) c2++;
        }
        return c1 + c2 * q;
    }

    private static int FrequentCount() {
        int count = 1;
        int max = 0;
        int maxCount = 0;
        int n = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        int a, b, i, j;
        for (i = 0; i < n; i++) s.append(scanner.nextInt());

        for (i = 0; i < s.length(); i++) {
            a = Character.getNumericValue(s.charAt(i));
            for (j = i + 1; j < s.length(); j++) {
                b = Character.getNumericValue(s.charAt(j));
                if (a == b)
                    count++;
            }
            if (count >= maxCount) {
                if (count == maxCount) {
                    if (a > max) {
                        max = a;
                    }
                } else {
                    max = a;
                    maxCount = count;
                }
            }
            count = 1;
        }

        return max;
        /*

    10
    2 5 4 6 7 5 1 2 2 2
    2

    */
    }

    private static int FrequentChar() {
        String s = scanner.nextLine();

        int count, max = 0;
        char ans = 'a', c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count = 0;
            if (Character.isLetter(c)) {
                for (int j = i; j < s.length(); j++) {
                    if (c == s.charAt(j)) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    ans = c;
                }
            }
        }

        return ans;
    }

    private static void expandAlphabetOccurrenceMain() {
        String ip = scanner.next();
        int l = ip.length(), i, j, m;
        for (i = 0; i < l - 1; ) {
            StringBuilder digit = new StringBuilder();
            StringBuilder str = new StringBuilder();
            if (isDigit(ip.charAt(i))) {
                while (i < l && isDigit(ip.charAt(i))) {
                    digit.append(ip.charAt(i));
                    i++;
                }
                while (i < l && !isDigit(ip.charAt(i))) {
                    str.append(ip.charAt(i));
                    i++;
                }
            } else {
                while (i < l && !isDigit(ip.charAt(i))) {
                    str.append(ip.charAt(i));
                    i++;
                }
                while (i < l && isDigit(ip.charAt(i))) {
                    digit.append(ip.charAt(i));
                    i++;
                }
            }
            if ((digit.length() > 0) && (str.length() > 0)) {
                int n = Integer.parseInt(digit.toString()), k = str.length();
                for (m = 0; m < k; m++) {
                    for (j = 0; j < n; j++) {
                        System.out.print(str.charAt(m));
                    }
                }
            }
        }
    }

    private static int N2_Occurrence_in_N1_Count() {
        int n = scanner.nextInt(), m = scanner.nextInt(), l = 0, cmp, i, count = 0;
        i = m;
        while (i > 0) {
            i = i / 10;
            l++;
        }

        double d = Math.pow(10, l);
        int div = (int) d;
        while (n > 0) {
            cmp = n % div;
            if (cmp == m) {
                count++;
            }
            n = n / div;
        }
        return count;

    }
}
