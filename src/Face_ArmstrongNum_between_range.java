import java.util.Scanner;

public class Face_ArmstrongNum_between_range {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] a) {
        int start = s.nextInt(), flag = 0;
        int end = s.nextInt();
        while (start < end) {
            if (start > 10 && isArmNumber(start)) {
                System.out.print(start + " ");
                flag = 1;
            }
            start++;
        }

        if (flag == 0) System.out.println("Armstrong Number not Found between the Given Interval.");
    }

    private static boolean isArmNumber(int n) {
        String str = "" + n;
        int l = str.length();
        int temp = n, d;
        double sum = 0;
        for (int i = 0; i < l; i++) {
            d = Character.getNumericValue(str.charAt(i));
            sum = sum + power(d, l);
            temp = temp / 10;
        }
        return sum == n;
    }

    private static int power(int n, int p) {
        int ans = n;
        for (int i = 1; i < p; i++) ans = ans * n;
        return ans;
    }
}
