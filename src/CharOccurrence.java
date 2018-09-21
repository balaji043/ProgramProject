import java.util.Scanner;

import static java.lang.Character.isDigit;

public class CharOccurrence {

    private static Scanner scanner = new Scanner(System.in);
    private static String s = scanner.next();
    private static char c = scanner.next().charAt(0);
    private static int n = scanner.nextInt(), l = s.length(), c1 = 0, c2 = 0, q = n / l, r = n % l;

    public static void main(String[] args) {
        System.out.println(getCharOcurrence());
        FrequentChar.FrequentCharmain();
        ExpandAlphabetOccurrence.ExpandAlphabetOccurrencemain();
        FrequentCount.FrequentCountmain();
        FrequentDigit.FrequentDigitmain();
    }

    private static int getCharOcurrence() {
        for (int i = 0; i < l; i++) {
            if (i < r && c == s.charAt(i)) c1++;
            if (c == s.charAt(i)) c2++;
        }

        return c1 + c2 * q;
    }
}

class FrequentChar {
    static void FrequentCharmain() {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(ans);
    }
}

class FrequentCount {
    private static Scanner sc = new Scanner(System.in);
    private static int count = 1;
    private static int max = 0;
    private static int maxCount = 0;
    private static int n = sc.nextInt();
    private static StringBuilder s = new StringBuilder();

    static void FrequentCountmain() {
        int a, b, i, j;
        for (i = 0; i < n; i++) s.append(sc.nextInt());

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

        System.out.println(max);
    }
/*

10
2 5 4 6 7 5 1 2 2 2
2

*/
}

class ExpandAlphabetOccurrence {
    static void ExpandAlphabetOccurrencemain() {
        Scanner scanner = new Scanner(System.in);
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
}

class FrequentDigit {
    static void FrequentDigitmain() {
        var scanner = new Scanner(System.in);
        int n1 = scanner.nextInt(), n2 = scanner.nextInt(), n3 = scanner.nextInt(), n4 = scanner.nextInt();
        System.out.println(mostFrequentDigits(n1, n2, n3, n4));

    }

    private static int mostFrequentDigits(int input1, int input2, int input3, int input4) {
        int n, a, b, count, max = 0;
        String string = "" + input1 + input2 + input3 + input4;
        n = Character.getNumericValue(string.charAt(0));
        for (int i = 0; i < string.length(); i++) {
            count = 1;
            a = Character.getNumericValue(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                b = Character.getNumericValue(string.charAt(j));
                if (a == b) count++;
            }
            if (count > max) {
                n = a;
                max = count;
            }
            if (count == max) {
                if (a > n) {
                    n = a;
                }
            }
        }
        return n;

    }
}
