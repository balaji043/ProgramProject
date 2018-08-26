import java.util.Scanner;

public class CharOccurrence {

    private static Scanner scanner = new Scanner(System.in);
    private static String s = scanner.next();
    private static char c = scanner.next().charAt(0);
    private static int n = scanner.nextInt(), l = s.length(), c1 = 0, c2 = 0, q = n / l, r = n % l;

    public static void main(String[] args) {

        for (int i = 0; i < l; i++) {
            if (i < r && c == s.charAt(i)) c1++;
            if (c == s.charAt(i)) c2++;
        }

        System.out.println(c1 + c2 * q);
    }
}