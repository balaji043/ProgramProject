import java.util.Scanner;

public class TowerOfHanoi {
    private static Scanner scanner = new Scanner(System.in);
    private static int start = 1, n = scanner.nextInt();
    private static int count = 0;
    public static void main(String ars[]) {
        TOH(n, 'A', 'C', 'B');
        System.out.println(count);
    }
    private static void TOH(int n, char from, char to, char using) {
        count++;
        if (start == n) {
            System.out.println("MOVE " + n + " From " + from + " To " + to + " Using " + using);
            return;
        }
        TOH(n - 1, from, using, to);
        System.out.println("MOVE " + n + " From " + from + " To " + to + " Using " + using);
        TOH(n - 1, using, to, from);
    }
}
