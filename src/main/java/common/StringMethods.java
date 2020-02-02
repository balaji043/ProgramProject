package common;

import java.util.Arrays;

public class StringMethods {
    private static String str = "ABCD";
    private static int n = str.length(), index = 0, size = getSize(n);
    private static String[] strings = new String[size];

    public static void main(String[] args) {
        permute(str.toCharArray(), 0, n - 1);
        System.out.println(index);
        for (String s : strings) {
            if (s.startsWith("A"))
                System.out.println(s);
            if (s.endsWith("D"))
                System.out.println(s);
        }
    }

    private static void permute(char[] str, int l, int r) {
        if (l == r) {
            strings[index] = new String(str);
            index++;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static void regexFunctions() {
        //String string = scanner.next();
        //System.out.println(string.replaceAll("[1]","5"));
        //System.out.println(string.replaceAll("[0-9]",""));
        //System.out.println(string.replaceAll("[0-9]","*"));
        String a = Arrays.toString(Array.getArray());
        System.out.println(a);
        System.out.println(a.replaceAll("[\\[\\]][,]", ""));
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    private static char[] swap(char[] a, int i, int j) {
        char temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    private static int getSize(int n) {
        if (n == 0) return 1;
        return n * getSize(n - 1);
    }
}
