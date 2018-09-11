import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner S = new Scanner(System.in);
        int a = S.nextInt();
        int i, j, k;
        int s = 2 * (a - 1);
        for (i = 0; i <= a; i++) {
            for (j = 0; j >= i; j--) {

                System.out.println(" ");
            }
            for (k = 1; k <= s; k++) {

            }
            System.out.print("*");

        }
    }
}