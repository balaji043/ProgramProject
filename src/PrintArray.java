package common;

import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = scanner.nextInt();
        printArray(n);
    }

    private static void printArray(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][0] = i + 1;
            a[0][i] = i + 1;
        }
        for (int i = 1; i < n; i++) {
            System.arraycopy(a[i - 1], 0, a[i], 1, n - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
