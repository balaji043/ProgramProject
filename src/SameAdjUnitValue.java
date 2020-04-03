

import java.util.Scanner;

public class SameAdjUnitValue {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt(), m = s.nextInt(), i, j, count = 0;
        int[][] a = new int[n][m];

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                a[i][j] = s.nextInt();
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m - 1; j++) {
                if (a[i][j] % 10 == a[i][j + 1] % 10) count = count + 2;
            }
        }

        System.out.print(count);

    }
}
/*
IP:

4 3
20 27 67
13
74 100
37 90 97
54 75 44

OP:
2
27 67 7 as unit digit count =2
*/
