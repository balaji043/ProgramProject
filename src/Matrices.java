

import java.util.Scanner;

public class Matrices {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Row and Column");
        int n1 = scanner.nextInt(), m1 = scanner.nextInt();
        System.out.println("Enter Matrix elements");
        int[][] a = get_Matrix(n1, m1);
        matrix_Print(matrix_Rotate(a));
    }

    private static int[][] get_Matrix(int n, int m) {
        if (n == 0 || m == 0) return null;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        return a;
    }


    private static int[][] matrix_Rotate(int[][] matrix) {
        System.out.println("Enter Degree");
        int deg = scanner.nextInt();
        if (matrix == null) return null;
        int n = matrix.length, m = matrix[0].length;
        int[][] rotated = new int[n][m];
        System.out.printf("Rotated %d times", deg / 90);
        for (int k = 0; k < deg / 90; k++) {
            for (int i = n - 1, i1 = 0; i >= 0; i--, i1++) {
                for (int j = 0; j < n; j++) {
                    rotated[i1][j] = matrix[j][i];
                }
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(rotated[i], 0, matrix[i], 0, m);
            }
        }
        System.out.println();
        return rotated;
    }

    private static void matrix_Print(int[][] a) {
        if (a == null) return;
        int m = a[0].length;
        for (int[] anA : a) {
            for (int j = 0; j < m; j++) {
                System.out.print(anA[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mul_Matrix(int[][] a, int[][] b) {
        if (a == null || b == null) return null;
        int n1 = a.length, m1 = a[0].length;
        int n2 = b.length, m2 = b[0].length;
        if (m1 != n2) {
            System.out.println("Not Possible");
            return null;
        }
        int[][] resultant = new int[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < n1; k++) {
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultant;
    }

    private static int[][] matrix_Transpose(int[][] matrix) {
        if (matrix == null) return null;
        int n = matrix.length, m = matrix[0].length;
        int[][] transpose = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    private static int[][] matrix_Add_Or_Sub(int[][] a, int[][] b, String operation) {
        if (a == null || b == null) return null;
        int n1 = a.length, m1 = a[0].length;
        int n2 = b.length, m2 = b[0].length;
        if (n1 != n2 || m1 != m2) {
            if (operation.equals("+")) {
                System.out.println("Cannot Add Matrix");
            } else {
                System.out.println("Cannot Subtract Matrix");
            }
            return null;
        }
        int[][] resultant = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                switch (operation) {
                    case "+": {
                        resultant[i][j] = a[i][j] + b[i][j];
                        break;
                    }
                    case "-": {
                        resultant[i][j] = a[i][j] - b[i][j];
                        break;
                    }
                }
            }
        }
        return resultant;
    }

    private static void print_Upper_Or_Lower_Matrix(int[][] a, int flag) {
        if (a == null) return;
        if (flag == 0) System.out.println("Upper");
        if (flag == 1) System.out.println("Lower");

        int n = a.length, m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flag == 0 && i <= j)
                    System.out.print(a[i][j] + " ");
                if (flag == 1 && j <= i)
                    System.out.print(a[i][j] + " ");
            }
        }

        System.out.println();
    }

    private static void print_Upper_Or_Lower_Matrix_Diagonal(int[][] a, int flag) {
        if (a == null) return;
        if (flag == 0) System.out.println("Upper");
        if (flag == 1) System.out.println("Lower");

        int n = a.length, m = a[0].length;
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (flag == 0 && i + k == j)
                        System.out.print(a[i][j] + " ");
                    if (flag == 1 && j + k == i)
                        System.out.print(a[i][j] + " ");
                }
            }

            System.out.println();
        }
    }
}
