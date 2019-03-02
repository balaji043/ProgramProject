import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(findProduct(4, 5, 7));

        System.out.println(findProduct(4, 7, 5));

        System.out.println(findProduct(7, 5, 8));

        System.out.println(findProduct(4, 5, 6));
    }

    private static int findProduct(int l, int m, int n) {
        if (l == 7) return m * n;
        if (m == 7) return n;
        if (n == 7) return 0;

        return l * m * n;
    }
}