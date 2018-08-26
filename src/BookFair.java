import java.util.Scanner;

public class BookFair {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static int[] stalls = new int[n];
    private static int inc = scanner.nextInt();
    private static int[] results = new int[n];

    public static void main(String args[]) {
        for (int i = 0; i < n; i++)
            stalls[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            results[i] = -1;
        //System.out.println(bookFair(0));
        //for (int i = 0; i < n; i++)
        // System.out.println(i+" "+results[i]);
        System.out.println(bookFairMemoizaion(0));

    }

    private static int bookFair(int i) {
        int yes = 0, no = 0;
        if (i >= n)
            return 0;
        yes = stalls[i] + bookFair(i + inc + 1);
        no = bookFair(i + 1);
        int ans = yes > no ? yes : no;
        results[i] = ans;
        return ans;
    }

    private static int bookFairMemoizaion(int i) {
        int yes = 0, no = 0;
        if (i >= n)
            return 0;
        if (results[i] != -1)
            return results[i];
        yes = stalls[i] + bookFairMemoizaion(i + inc + 1);
        no = bookFairMemoizaion(i + 1);
        results[i] = yes > no ? yes : no;
        System.out.println("i: "+i + " val " +stalls[i]+" yes "+ yes+" call "+(i+inc+1) + " no " + no +" call "+(i+1)+ " res " + results[i]);
        return results[i];
    }
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
