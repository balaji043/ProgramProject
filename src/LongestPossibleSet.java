import java.util.Scanner;

public class LongestPossibleSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int i, j, k1, k2, k3, count1, count2 , max = 0;
        int a[] = new int[n];

        for (i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for (i = 0; i < n - 1; i++) {
            count1 = 1;
            count2 = 1;
            k1 = a[i];
            k2 = a[i] + 1;
            k3 = a[i] - 1;
            for (j = i + 1; j < n; j++) {
                if (a[j] == k1 || a[j] == k2) count1++;
                if (a[j] == k1 || a[j] == k3) count2++;
            }
            if (count1 > max) max = count1;
            if (count2 > max) max = count2;
        }
        System.out.print(max);
    }
}