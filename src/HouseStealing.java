import java.util.Scanner;

public class HouseStealing {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] value = new int[n];
    private static int[] weight = new int[n];
    private static int W ;//= scanner.nextInt();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }
        /*for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }*/

        System.out.println(maxStealing(0));
        //System.out.println(maxStealingKnappSack(0, 0));
    }

    private static int maxStealing(int i) {
        if (i >= n)
            return 0;
        int yes = value[i] + maxStealing(i + 2);
        int no = maxStealing(i + 1);
        return yes > no ? yes : no;
    }

    private static int maxStealingKnappSack(int i, int w) {
        if(i>=n) return 0;
        int ifSteal = 0;
        if (w+weight[i] <= W) {
            ifSteal = value[i] + maxStealingKnappSack(i + 1, w + weight[i]);
        }
        int ifNotSteal = maxStealingKnappSack(i + 1, w);

        return ifSteal > ifNotSteal ? ifSteal : ifNotSteal;
    }
}
/*

3
60 100 120
10 20 30
50

*/
