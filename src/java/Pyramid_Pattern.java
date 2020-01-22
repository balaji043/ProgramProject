package java;

import java.util.Scanner;

public class Pyramid_Pattern {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    }


    private static void pascalTriangle() {
    }

    private static void pyramidPattern() {
        int n = scanner.nextInt();
        int i, j, k, d = 1;
        for (i = 0; i < n; i++, d = d + 2) {
            for (j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (k = 0; k < d; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /*
         *           *
         *         * * *
         *       * * * * *
         * */
    }
}
