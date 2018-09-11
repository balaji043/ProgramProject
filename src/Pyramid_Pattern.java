import java.util.Scanner;

public class Pyramid_Pattern {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int i, j, k, d = 1;
        for (i = 0; i < n; i++, d = d + 2) {
            for (j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            for (k = 0; k < d; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
/*
 *           *
 *         * * *
 *       * * * * *
 * */