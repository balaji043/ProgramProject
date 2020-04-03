
import java.util.Arrays;
import java.util.Scanner;

public class TCS_Gem_Collection {
    private static Scanner sc = new Scanner(System.in);
    private static int t = sc.nextInt();
    private static int[] ans = new int[t];
    private static int[] memo = new int[100];

    public static void main(String[] args) {
        Arrays.fill(memo, 0);
        for (int i = 0; i < t; i++) {
            ans[i] = gemCollection(sc.nextInt());
        }
        for (int i = 0; i < t; i++) {
            System.out.print(ans[i]);
        }
    }

    private static int gemCollection(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return recursion(a, n, 0, 0, 1);
    }

    private static int recursion(int[] a, int n, int i, int count, int flag) {
        int pick = 0, no;
        if (i >= n)
            return 0;
        if (memo[i] != 0) {
            if (flag == 1) {
                return memo[i];
            } else {
                if (count == 3) {
                    if (i + 1 >= n)
                        return memo[i];
                    else
                        return memo[i] + a[i + 1] + recursion(a, n, i + 2, 0, 1);
                } else {
                    return memo[i];
                }
            }
        } else {
            if (flag == 1) {
                pick = a[i] + recursion(a, n, i + 2, 0, 1);
                no = recursion(a, n, i + 1, count + 1, 0);
            } else {
                if (count == 3) {
                    if (i + 1 < n)
                        pick = a[i] + a[i + 1] + recursion(a, n, i + 2, 0, 1);
                    no = recursion(a, n, i + 1, 1, 0);
                } else {
                    pick = a[i] + recursion(a, n, i + 2, 0, 1);
                    no = recursion(a, n, i + 1, count + 1, 0);
                }
            }
        }

        return pick > no ? pick : no;
    }
}
