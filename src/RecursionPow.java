

import java.math.BigDecimal;
import java.util.Scanner;

public class RecursionPow {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), p = scanner.nextInt();
        System.out.println(powerRecursion(n, p));
        System.out.println(powerRecursionMul(n, p));
        BigDecimal b = new BigDecimal(Math.pow(n, p));
        String s = "" + b;
        System.out.println(b + " " + s.length());
    }

    private static long powerRecursion(long n, long p) {
        if (p == 0) return 1;
        return n * powerRecursion(n, p - 1);
    }

    private static long powerRecursionMul(long n, long p) {
        if (p == 0) return 1;
        if (p % 2 == 0) {
            p = p / 2;
            return powerRecursionMul(n * n, p);
        } else {
            return n * powerRecursionMul(n, p - 1);
        }
    }
}
