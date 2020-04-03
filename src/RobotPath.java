

import java.util.Scanner;

public class RobotPath {
    private static int n, m;

    public static void main(String[] sa) {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        i = scanner.nextInt();
        j = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(path(i, j));
    }

    private static int path(int i, int j) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (i >= n || j >= m)
            return 0;
        return path(i, j + 1) + path(i + 1, j);
    }
}
