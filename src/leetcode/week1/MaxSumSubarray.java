import java.util.logging.Logger;

/**
 * Simple idea of the Kadane’s algorithm is to look for all positive contiguous
 * segments of the array (max_ending_here is used for this). And keep track of
 * maximum sum contiguous segment among all positive segments (max_so_far is
 * used for this). Each time we get a positive sum compare it with max_so_far
 * and update max_so_far if it is greater than max_so_far.
 * 
 */
public class MaxSumSubarray {

    private static final Logger logger = Logger.getLogger(MaxSumSubarray.class.getName());

    public static void main(String[] args) {
        int[] nums1 = { -2, -3, 4, -1, -2, 1, 5, -3 };
        logger.info("" + getMaxSumSubArray(nums1));

        int[] nums2 = { -1 };
        logger.info("" + getMaxSumSubArray(nums2));

        int[] nums3 = { 1 };
        logger.info("" + getMaxSumSubArray(nums3));
    }

    private static int getMaxSumSubArray(int[] nums) {
        int finalSum = nums[0];
        int stepSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            stepSum = Math.max(nums[i], stepSum + nums[i]);
            finalSum = Math.max(stepSum, finalSum);
        }
        return finalSum;
    }

}