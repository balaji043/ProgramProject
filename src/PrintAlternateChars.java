package common;

import java.util.Scanner;

public class PrintAlternateChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l1, l2, l, i, j;
        l = s.length();
        l1 = sc.nextInt();
        l2 = l - l1;
        j = 0;
        for (i = 1; i < l1 * 2; i = i + 2) {
            System.out.print(s.charAt(i));
        }
        System.out.print("\n");
        for (i = 1; i < l2 * 2; i = i + 2) {
            System.out.print(s.charAt(j));
        }
    }
}
/*
input;

LBARZIYSK //two interlaced strings
4  // Length of first string

output:
LAZY
BRISK
*/
