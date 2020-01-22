package java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class SortMerge {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        splitMerge(scanner.next(), scanner.next());
    }

    private static void splitMerge(String arr1, String arr2) {

        String[] ar1 = arr1.split(",");
        String[] ar2 = arr2.split(",");
        int i, n = ar1.length + ar2.length;
        int[] ar = new int[n];
        TreeSet<Integer> a = new TreeSet<>();
        for (String x : ar1) a.add(Integer.parseInt(x));
        for (String x : ar2) a.add(Integer.parseInt(x));
        for (i = 0; i < ar2.length; i++) {
            System.out.print(ar2[i]);
            ar[i] = Integer.parseInt(ar2[i]);
        }
        Arrays.sort(ar);
        for (i = 0; i < ar2.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}
