package java;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectNumber {

    public static void main(String[] args) {
        Scanner bucky = new Scanner(System.in);
        int n = bucky.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isPerfect(i))
                System.out.println(i);
        }
    }

    private static boolean isPerfect(int n) {
        ArrayList<Integer> factors = getFactors(n);
        int sum = 0;
        for (Integer a : factors) {
            sum += a;
        }
        return sum == n;
    }

    private static ArrayList<Integer> getFactors(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
