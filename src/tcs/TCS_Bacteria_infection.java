import java.util.Scanner;

public class TCS_Bacteria_infection {
    private static Scanner scanner = new Scanner(System.in);
    private static int t = scanner.nextInt(), index = 0, desc = 0;
    private static String[] a = new String[30];

    public static void main(String[] args) {
        for (int i = 0; i < t; i++) infect(scanner.nextInt(), scanner.nextInt());
        for (int i = 0; i < desc; i++) System.out.println(a[i]);
    }

    private static void infect(int n, int m) {
        int[][] ans = new int[n][m];
        desc = desc + n;
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] d = (scanner.next()).split("");
            for (int j = 0; j < m; j++) {
                ans[i][j] = Integer.parseInt(d[j]);
                b[i][j] = ans[i][j];
            }
        }
        int ji = scanner.nextInt();
        int ki = scanner.nextInt();
        int jj = scanner.nextInt();
        int kj = scanner.nextInt();
        int k = scanner.nextInt(), count;

        for (int t = 0; t < k; t++) {
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ans[i][j] == 1) {
                        if (i != 0 && j != 0) {
                            if (ans[i - 1][j - 1] == 1) {   //left-up
                                count++;
                            }
                        }
                        if (i != 0 && j != m - 1) {
                            if (ans[i - 1][j + 1] == 1) {   //left-Down
                                count++;
                            }
                        }
                        if (i != n - 1 && j != 0) {
                            if (ans[i + 1][j - 1] == 1) { // right - up
                                count++;
                            }
                        }
                        if (i != n - 1 && j != m - 1) {
                            if (ans[i + 1][j + 1] == 1) {   //Right-down
                                count++;
                            }
                        }
                        if (i != 0) {
                            if (ans[i - 1][j] == 1) {    // left
                                count++;
                            }
                        }
                        if (i != n - 1) {
                            if (ans[i + 1][j] == 1) {   //right
                                count++;
                            }
                        }
                        if (j != 0) {
                            if (ans[i][j - 1] == 1) {    //up
                                count++;
                            }
                        }
                        if (j != m - 1) {
                            if (ans[i][j + 1] == 1) {  // Down
                                count++;
                            }
                        }
                        if (!(count >= ji && count <= jj)) {
                            b[i][j] = 0;
                        }

                    } else {
                        if (i != 0 && j != 0) {
                            if (ans[i - 1][j - 1] == 1) {   //left-up
                                count++;
                            }
                        }
                        if (i != 0 && j != m - 1) {
                            if (ans[i - 1][j + 1] == 1) {   //left-Down
                                count++;
                            }
                        }
                        if (i != n - 1 && j != 0) {
                            if (ans[i + 1][j - 1] == 1) { // right - up
                                count++;
                            }
                        }
                        if (i != n - 1 && j != m - 1) {
                            if (ans[i + 1][j + 1] == 1) {   //Right-down
                                count++;
                            }
                        }
                        if (i != 0) {
                            if (ans[i - 1][j] == 1) {    // left
                                count++;
                            }
                        }
                        if (i != n - 1) {
                            if (ans[i + 1][j] == 1) {   //right
                                count++;
                            }
                        }
                        if (j != 0) {
                            if (ans[i][j - 1] == 1) {    //up
                                count++;
                            }
                        }
                        if (j != m - 1) {
                            if (ans[i][j + 1] == 1) {  // Down
                                count++;
                            }
                        }
                        if ((count >= ki && count <= kj)) {
                            b[i][j] = 1;
                        }
                    }
                    count = 0;
                }
            }

            for (int i = 0; i < n; i++) {
                if (m >= 0) System.arraycopy(b[i], 0, ans[i], 0, m);
            }
        }
        print(ans, n, m);
    }

    static void print(int[][] ans, int n, int m) {
        for (int i = 0; i < n; i++) {
            a[index] = ""+ans[i][0];
            for (int j = 0; j < m; j++) {
                a[index] = a[index]+" "+ans[i][j];
            }
            index++;
        }
    }
}
/*
1

4 4

0000

0110

0010

0101

2 2

2 3

3

Output


2

6 6

000011

011011

001011

011111

111100

010101

2 2

2 3

7

10 4

0101

1111

0000

0110

0010

0101

1111

1111

0000

0000

2 2

2 3

15
 */
