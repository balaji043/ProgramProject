import java.math.BigDecimal;
import java.util.Scanner;

public class StairCaseProblem {

    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] resultsInt = new int[n];
    private static BigDecimal[] resultsBigDecimal = new BigDecimal[n];

    public static void main(String args[]) {
        //System.out.print(Staircase(0));
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