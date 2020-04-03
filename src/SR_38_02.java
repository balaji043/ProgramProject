

import java.util.Scanner;

public class SR_38_02 {
    private static Scanner scanner = new Scanner(System.in);
    private static int row = scanner.nextInt();
    private static int col = scanner.nextInt();
    private static int[][] trees = new int[row][col];

    public static void main(String[] args) {
        int i, j, k, n, m;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                trees[i][j] = scanner.nextInt();
            }
        }
        n = scanner.nextInt();
        m = scanner.nextInt();
        int n1 = n * 2;
        for (k = 0; k < m; k++) {
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        trees[i][j] = trees[i][j] + n1;
                    } else {
                        trees[i][j] = trees[i][j] + n;
                    }
                }
            }
        }
        for(i =0; i <row; i++){
            for (j = 0; j < col; j++) {
                System.out.print(trees[i][j] + " ");
            }
            System.out.println();
        }
    }
}
