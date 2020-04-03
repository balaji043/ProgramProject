

import java.util.Scanner;

public class Wipro_Alternate_Add_Sub {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(AddSub(scanner.nextInt(), scanner.nextInt()));
    }

    private static int AddSub(int input1, int input2) {
        int sum = input1, f;
        if (input2 == 1) {
            f = 1;
        } else {
            f = 0;
        }
        for (int i = input1 - 1; i > 0; i--) {
            if (f == 1) {
                sum = sum - i;
                f = 0;
            } else {
                sum = sum + i;
                f = 1;
            }
        }
        return sum;
    }
}
