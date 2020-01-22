package java;

import java.util.Scanner;

public class TreeMatrixShadow {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt(), m = read.nextInt(), c = 0;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = read.nextInt();

        char ch = read.next().charAt(0);

        switch (ch) {
            case 'F': {
                for (int i = 1; i < n; i++)
                    for (int j = 0; j < m; j++)
                        if (a[i - 1][j] == 0 && a[i][j] == 1) c++;
                break;
            }
            case 'B': {
                for (int i = 0; i < n - 1; i++)
                    for (int j = 0; j < m; j++)
                        if (a[i + 1][j] == 0 && a[i][j] == 1) c++;

                break;
            }
            case 'L':{
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m-1; j++)
                        if(a[i][j]==1 && a[i][j+1]==0) c++;
                break;
            }
            case 'R':{
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m-1; j++)
                        if(a[i][j+1]==1 && a[i][j]==0) c++;
                break;
            }
        }
        System.out.println(c);
    }
}
/*
4 4
1 0 1 0
1 0 1 0
1 0 1 1
1 1 0 0
F or B or R or L
 */
