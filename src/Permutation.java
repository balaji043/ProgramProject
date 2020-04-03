

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    private static Scanner scanner = new Scanner(System.in);
    private static String str = scanner.next();
    private static int n1 = scanner.nextInt(), j = 0;
    private static int[] ans = new int[str.length() + 1];

    public static void main(String[] args) {
        int n = str.length();
        char[] array = str.toCharArray();
        Arrays.sort(array);
        // permutation.permute(array, 0, n - 1);
        System.out.println();
        permute(array, 0, n - 1);
        System.out.println(ans[0]);

    }

    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     *            <p>
     *            Swap Characters at position
     */
    private static void permute(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(new String(str));
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    private static char[] swap(char[] a, int i, int j) {
        char temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    /**
     * permutation function that prints the smallest mul of n1 value
     *
     * @param str char array
     * @param l   starting index
     * @param r   ending index
     *           <p>
     *            Swap Characters at position
     */
    private static void permuteMul(char[] str, int l, int r) {
        String s = new String(str);
        if (l == r && Integer.parseInt(s) % n1 == 0) {
            ans[j] = Integer.parseInt(s);
            j++;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permuteMul(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }
}
// This code is contributed by Mihir Joshi
