package java.face;

import java.util.Scanner;

public class EqualsString {
    private static Scanner scanner = new Scanner(System.in);
    private static String s1 = scanner.next(), s2 = scanner.next();
    private static int count1 = 0, count2 = 0, count3 = 0;

    public static void main(String[] args) {
        int i = 0, j = 0;
        char[] string1 = s1.toCharArray();
        char[] string2 = s2.toCharArray();
        System.out.println(minEditStringEquals(string1, string2, i, j));
    }

    private static int minEditStringEquals(char[] string1, char[] string2, int i, int j) {

        if (i >= string2.length || j >= string2.length) return 0;
        if (string1[i] == string2[j]) {
            minEditStringEquals(string1, string2, i + 1, j + 1);
            return 0;
        }else{
            minEditStringEquals(string1,string2,i,j+1);         count1++;
            minEditStringEquals(string1,string2,i+1,j+1);     count2++;
            minEditStringEquals(string1,string2,i+1,j+1);      count3++;
        }
        int temp=(count1<count2)?count1:count2;
        return (temp<count3)?temp:count3;
    }
}
