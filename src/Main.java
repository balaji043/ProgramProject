import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int n = scanner.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (isPrime(i)) ans.append(",").append(i);
        System.out.println(ans.substring(1));
    }

    private static boolean isPrime(int n) {
        if (n == 1 || n <= 0) return false;
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}