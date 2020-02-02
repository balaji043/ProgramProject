package common;

import java.util.Arrays;
import java.util.Scanner;

public class Non_Repeating_Int {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2 * scanner.nextInt() - 1;
        int[] a = new int[n];
        int i, j, k, ans = 0, count;
        for (i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        for (i = 0; i < n - 1; i++) {
            k = a[i];
            count = 0;
            if (a[i] != 0) {
                for (j = i + 1; j < n; j++) {
                    if (k == a[j]) {
                        a[j] = 0;
                        count++;
                    } else break;
                }
                if (count == 0) {
                    ans = k;
                    break;
                }
                if (count > 0) {
                    a[i] = 0;
                }
            }
        }
        System.out.print(ans);
    }
}
