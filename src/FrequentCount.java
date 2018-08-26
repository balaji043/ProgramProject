import java.util.Scanner;

public class FrequentCount {
    private static Scanner sc = new Scanner(System.in);
    private static int count = 1;
    private static int max = 0;
    private static int maxCount = 0;
    private static int n = sc.nextInt();
    private static StringBuilder s = new StringBuilder();

    public static void main(String[] args) {
        int a,b,i,j;
        for (i = 0; i < n; i++) s.append(sc.nextInt());

        for (i = 0; i < s.length(); i++) {
            a = Character.getNumericValue(s.charAt(i));
            for (j = i + 1; j < s.length(); j++) {
                 b = Character.getNumericValue(s.charAt(j));
                if (a == b)
                    count++;
            }
            if (count >= maxCount) {
                if (count == maxCount) {
                    if (a > max) {
                        max = a;
                    }
                } else {
                    max = a;
                    maxCount = count;
                }
            }
            count = 1;
        }

        System.out.println(max);
    }
}

/*

10
2 5 4 6 7 5 1 2 2 2
2

*/