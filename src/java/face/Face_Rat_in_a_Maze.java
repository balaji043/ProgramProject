package java.face;

import java.util.Scanner;

class Face_Rat_in_a_Maze {
    private static Scanner s = new Scanner(System.in);
    private static int n = s.nextInt();
    static int[][] a = new int[n][n];
    private static int ways;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = s.nextInt();

        findWays(0, 0);
        System.out.println(ways);
    }

    private static void findWays(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || a[i][j] == 1)
            return;
        if (i == n - 1 && j == n - 1) {
            ways++;
            return;
        }
        a[i][j] = 1;
        findWays(i + 1, j);
        findWays(i - 1, j);
        findWays(i, j + 1);
        findWays(i, j - 1);
        a[i][j] = 0;
    }
}
