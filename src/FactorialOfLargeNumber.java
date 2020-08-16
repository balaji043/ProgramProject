
import java.util.Scanner;

class FactorialOfLargeNumber {
    public static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();

        String[] ans = new String[noOfTestCases];
        for (int i = 0; i < noOfTestCases; i++) {
            ans[i] = "" + scanner.nextInt();
        }
        for (int i = 0; i < noOfTestCases; i++) {
            System.out.println(factorialOfNumber(Integer.parseInt(ans[i])));
        }
    }

    private static String factorialOfNumber(int num) {
        int[] res = new int[MAX];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= num; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = res_size - 1; i >= 0; i--)
            stringBuilder.append(res[i]);
        return stringBuilder.toString();
    }

    // This function multiplies x with the number
    // represented by res[]. resSize is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of resSize
    // and returns the new value of resSize
    static int multiply(int x, int[] res, int resSize) {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < resSize; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod / 10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[resSize] = carry % 10;
            carry = carry / 10;
            resSize++;
        }
        return resSize;
    }
}