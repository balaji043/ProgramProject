

import java.util.Scanner;

class Wipro_Nambiar_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nnGenerator(scanner.next()));
    }

    private static int nnGenerator(String input1) {
        int l = input1.length(), k, sum = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if (Character.getNumericValue(input1.charAt(i)) % 2 == 0) {
                for (k = i; k < l; k++) {
                    sum = sum + Character.getNumericValue(input1.charAt(k));
                    if (sum % 2 != 0) {
                        break;
                    }
                }
            } else {
                for (k = i; k < l; k++) {
                    sum = sum + Character.getNumericValue(input1.charAt(k));
                    if (sum % 2 == 0) {
                        break;
                    }
                }
            }
            i = k;
            ans.append(sum);
            sum = 0;
        }
        return Integer.parseInt(ans.toString());
    }
}
