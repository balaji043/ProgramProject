public class HappyNumber {
    public static void main(String[] args) {
        // System.out.println(isHappyNumber(20));
        System.out.println(isHappyNumber(19));
    }

    private static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findDigitSquareSum(slow);
            fast = findDigitSquareSum(findDigitSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int findDigitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}