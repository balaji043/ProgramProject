

import java.util.Scanner;

class Array {
    static int[] getArray() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        return a;
    }

    static int[] getArray(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        return a;
    }

    static void printArray(int[] a, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
