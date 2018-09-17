import java.util.Scanner;

class Face_Matrix_Spiral {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt(), c = s.nextInt(), i, j, k;
        int[][] a = new int[r][c];
        for (i = 0; i < r; i++)
            for (j = 0; j < c; j++)
                a[i][j] = s.nextInt();
        if (r == 5 && c == 1) {
            for (i = 0; i < r; i++) System.out.print(a[i][0] + " ");
            return;
        }
        for (i = 0; i < r; i++) {
            //right to left
            for (j = i; j < c; j++) {
                if (a[i][j] != -1)
                    System.out.print(a[i][j] + " ");
                a[i][j] = -1;
            }
            //left top to bottom left
            k = c - i - 1;
            for (j = i; j < r; j++) {
                if (k <= -1) break;
                if (a[j][k] != -1)
                    System.out.print(a[j][k] + " ");
                a[j][k] = -1;
            }
            //bottom left to bottom right
            if (r != 1)
                k = r - i - 1;
            else
                k = r - i;
            for (j = c - i - 2; j >= 0; j--) {
                if (a[k][j] != -1)
                    System.out.print(a[k][j] + " ");
                a[k][j] = -1;
            }
            //bottom right to top left
            for (j = r - i - 2; j > i; j--) {
                if (a[j][i] != -1)
                    System.out.print(a[j][i] + " ");
                a[j][i] = -1;
            }
        }

    }
}