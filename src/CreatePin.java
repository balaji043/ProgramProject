import java.util.Arrays;
import java.util.Scanner;

public class CreatePin {
    public static void main(String[] ar) {
        int n1, n2, n3;
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        System.out.println(createPin(n1, n2, n3));
    }

    private static String createPin(int n1, int n2, int n3) {

        String a[] = ("" + n1).split("");
        String b[] = ("" + n2).split("");
        String c[] = ("" + n3).split("");

        int m1 = min(
                Character.getNumericValue((a[0].charAt(0))),
                Character.getNumericValue((b[0].charAt(0))),
                Character.getNumericValue((c[0].charAt(0))));
        int m2 = min(
                Character.getNumericValue((a[1].charAt(0))),
                Character.getNumericValue((b[1].charAt(0))),
                Character.getNumericValue((c[1].charAt(0))));
        int m3 = min(
                Character.getNumericValue((a[2].charAt(0))),
                Character.getNumericValue((b[2].charAt(0))),
                Character.getNumericValue((c[2].charAt(0))));
        String s = "" + n1 + n2 + n3;
        char sarr[] = s.toCharArray();
        Arrays.sort(sarr);

        return "" + sarr[s.length() - 1] + m1 + m2 + m3;
    }

    private static int min(int a, int b, int c) {
        return c < (a < b ? a : b) ? c : ((a < b) ? a : b);
    }
}
