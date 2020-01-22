package java;

import java.util.Scanner;

public class Search {
    public static void main(String[] ss) {
        searchSecondMax();
    }

    private static void searchMax() {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt(),max=-100000000;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }

    private static void searchSecondMax(){

        Scanner s = new Scanner(System.in);

        int n=s.nextInt(),i,max=-1000000;
        int[] a=new int[n];

        for (i = 0; i < n; i++)
            a[i] = s.nextInt();
        for (i = 0; i < n; i++) {

            if (a[i] > max) {
                max = a[i];
            }

            if (i == n - 1 && max == a[0]) {
                i = 1;
                max = a[1];
            }
        }
        System.out.println(max);
    }
}
