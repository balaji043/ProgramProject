import java.util.Scanner;

import static java.lang.Math.abs;

public class Wipro_Police_Thief {
    public static void main(String args[]) {
        thiefCatch();
    }

    private static void thiefCatch() {
        Scanner S = new Scanner(System.in);
        int t = S.nextInt();
        int p1, p2, th;
        int[] ans = new int[t];
        for (int i = 0; i < t; i++) {
            p1 = S.nextInt();
            p2 = S.nextInt();
            th = S.nextInt();
            ans[i] = Police(p1, p2, th);
        }
        for (int i = 0; i < t; i++)
            if (ans[i] == 1) {
                System.out.println("Police1");
            } else if (ans[i] == 2) {
                System.out.println("Police2");
            } else {
                System.out.println("Both");
            }
    }

    private static int Police(int p1, int p2, int th) {
        int fp = abs(p1 - th);
        int sp = abs(p2 - th);
        if (fp > sp) {
            return 2;
        } else if (fp < sp) {
            return 1;
        } else {
            return 0;
        }
    }
}


