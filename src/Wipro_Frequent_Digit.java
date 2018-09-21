import java.util.Scanner;

public class Wipro_Frequent_Digit {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n1 = scanner.nextInt(), n2 = scanner.nextInt(), n3 = scanner.nextInt(), n4 = scanner.nextInt();
        System.out.println(mostFrequentDigits(n1, n2, n3, n4));

    }

    private static int mostFrequentDigits(int input1, int input2, int input3, int input4) {
        int n, a, b, count, max = 0;
        String string = "" + input1 + input2 + input3 + input4;
        n = Character.getNumericValue(string.charAt(0));
        for (int i = 0; i < string.length(); i++) {
            count = 1;
            a = Character.getNumericValue(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                b = Character.getNumericValue(string.charAt(j));
                if (a == b) count++;
            }
            if (count > max) {
                n = a;
                max = count;
            }
            if (count == max) {
                if (a > n) {
                    n = a;
                }
            }
        }
        return n;

    }
}
