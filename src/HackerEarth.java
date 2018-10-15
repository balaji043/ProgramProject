import java.util.Scanner;

public class HackerEarth {
    private static int testCases, i, j = 0, k = 0, ans = 0, n = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(monk_Visits_CoderLand());
    }

    private static int monk_Visits_CoderLand() {
        testCases = scanner.nextInt();
        while (testCases != 0) {
            n = scanner.nextInt();
            int[] a = Array.getArray(n), b = Array.getArray(n);
            int minimum = 1000000;
            for (i = 0; i < n; i++) {
                minimum = min(minimum, a[i]);
                ans += minimum * b[i];
            }
            testCases--;
        }
        return ans;
    }

    private static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
