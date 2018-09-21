import java.math.BigDecimal;
import java.util.Scanner;

public class knappSack {
    public static void main(String[] args) {
        HouseStealing.houseStealingMain();
        BookFair.bookFairMain();
        StairCaseProblem.stairCaseMain();
    }
}

class HouseStealing {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] value = new int[n];
    private static int[] weight = new int[n];
    private static int W = scanner.nextInt();

    static void houseStealingMain() {

        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }

        System.out.println(maxStealing(0));
        System.out.println(maxStealingKnappSack(0, 0));
    }

    private static int maxStealing(int i) {
        if (i >= n)
            return 0;
        int yes = value[i] + maxStealing(i + 2);
        int no = maxStealing(i + 1);
        return yes > no ? yes : no;
    }

    private static int maxStealingKnappSack(int i, int w) {
        if (i >= n) return 0;
        int ifSteal = 0;
        if (w + weight[i] <= W) {
            ifSteal = value[i] + maxStealingKnappSack(i + 1, w + weight[i]);
        }
        int ifNotSteal = maxStealingKnappSack(i + 1, w);

        return ifSteal > ifNotSteal ? ifSteal : ifNotSteal;
    }
/*

3
60 100 120
10 20 30
50

*/
}

class BookFair {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] stalls = new int[n];
    private static int inc = scanner.nextInt();
    private static int[] results = new int[n];

    static void bookFairMain() {
        for (int i = 0; i < n; i++)
            stalls[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            results[i] = -1;
        System.out.println(bookFair(0));
        System.out.println(bookFairMemoization(0));

    }

    private static int bookFair(int i) {
        int yes, no;
        if (i >= n)
            return 0;
        yes = stalls[i] + bookFair(i + inc + 1);
        no = bookFair(i + 1);
        int ans = yes > no ? yes : no;
        results[i] = ans;
        return ans;
    }

    private static int bookFairMemoization(int i) {
        int yes, no;
        if (i >= n)
            return 0;
        if (results[i] != -1)
            return results[i];
        yes = stalls[i] + bookFairMemoization(i + inc + 1);
        no = bookFairMemoization(i + 1);
        results[i] = yes > no ? yes : no;
        System.out.println("i: " + i + " val " + stalls[i] + " yes " + yes + " call " + (i + inc + 1) + " no " + no + " call " + (i + 1) + " res " + results[i]);
        return results[i];
    }
/*

10
2
4 5 8 7 5 4 3 4 6 5 2

10
2
50 70 40 50 90 70 60 40 70 50
6
2
15 4 6 2 5 6
*/
}

class StairCaseProblem {

    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] resultsInt = new int[n];
    private static BigDecimal[] resultsBigDecimal = new BigDecimal[n];

    static void stairCaseMain() {
        System.out.print(Staircase(0));
        System.out.println(StaircaseMemoizationInt(0));
        System.out.println(StaircaseMemoizationBD(0));
    }

    private static int Staircase(int s) {

        if (s == n)
            return 1;

        if (s > n)
            return 0;

        return Staircase(s + 1) + Staircase(s + 2);
    }

    private static int StaircaseMemoizationInt(int s) {

        if (s == n)
            return 1;

        if (s > n)
            return 0;

        if (resultsInt[s] != -1)
            return resultsInt[s];

        resultsInt[s] = StaircaseMemoizationInt(s + 1) + StaircaseMemoizationInt(s + 2);
        return resultsInt[s];
    }

    private static BigDecimal StaircaseMemoizationBD(int s) {

        if (s == n)
            return new BigDecimal(1);

        if (s > n)
            return new BigDecimal(0);

        if (resultsBigDecimal[s] != null)
            return resultsBigDecimal[s];

        resultsBigDecimal[s] = (StaircaseMemoizationBD(s + 1)).add(StaircaseMemoizationBD(s + 2));
        return resultsBigDecimal[s];
    }
}