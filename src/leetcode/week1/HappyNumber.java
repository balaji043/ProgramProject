import java.util.logging.Logger;

/**
 * we will keep two numbers slow and fast both initialize from a given number,
 * slow is replaced one step at a time and fast is replaced two steps at a time.
 * If they meet at 1, then the given number is Happy Number otherwise not.
 * Input: n = 19 Output: True 19 is Happy Number, 1^2 + 9^2 = 82 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

    private static final Logger logger = Logger.getLogger(HappyNumber.class.getName());

    public static void main(String[] args) {
        logger.info("" + isHappyNumber(20));
        logger.info("" + isHappyNumber(19));
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