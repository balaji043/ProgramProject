import java.util.Scanner;

public class Combinations {

    private static Scanner scanner = new Scanner(System.in);
    static int count = 1;

    public static void main(String[] args) {

        int n = scanner.nextInt();                                  // Array size
        int[] numbers = new int[n];
        int[] selected = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();                         // Array values
        }

        combinations(numbers, selected, 0, 0, n);               // All possible combinations

        int s = scanner.nextInt();

        combinationSum(numbers, selected, 0, 0, n, s);          // All possible combinations sum == s
        combinationSumCount(numbers, selected, 0, 0, n, s);     // All possible combinations sum count

        System.out.println(count);
    }

    private static void combinations(int[] numbers, int[] selected, int i, int j, int n) {

        if (i > n || j > n)                     //Boundary Conditions
            return;

        if (i == n) {                           //print the combinations in selected array
            for (int k = 0; k < j; k++) {
                System.out.print(selected[k] + " " + "");
            }
            System.out.println();
            return;
        }
        selected[j] = numbers[i];               // Selecting a number from the array
        combinations(numbers, selected, i + 1, j + 1, n);
        selected[j] = 0;
        combinations(numbers, selected, i + 1, j, n);

    }

    private static void combinationSum(int[] numbers, int[] selected, int i, int j, int n, int s) {

        if (i > n || j > n)
            return;

        if (i == n) {
            int sum = 0;
            for (int k = 0; k < j; k++) {//sum for each combinations
                sum = sum + selected[k];
            }
            if (sum == s) {
                for (int k = 0; k < j; k++) {
                    System.out.print(selected[k] + " ");  //print combination for each
                }
                System.out.println();
            }
            return;
        }

        selected[j] = numbers[i];
        combinationSum(numbers, selected, i + 1, j + 1, n, s);
        selected[j] = 0;
        combinationSum(numbers, selected, i + 1, j, n, s);

    }

    private static void combinationSumCount(int[] numbers, int[] selected, int i, int j, int n, int s) {
        if (i > n || j > n)
            return;
        if (i == n) {
            int sum = 0;
            for (int k = 0; k < j; k++) {
                sum = sum + selected[k];
            }
            if (sum == s)
                count++;
            return;

        }
        selected[j] = numbers[i];
        combinationSumCount(numbers, selected, i + 1, j + 1, n, s);
        selected[j] = 0;
        combinationSumCount(numbers, selected, i + 1, j, n, s);
    }
}

/*
3
1 2 3
*/
