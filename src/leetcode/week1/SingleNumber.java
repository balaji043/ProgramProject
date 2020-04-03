/**
 * Let us consider the above example. Let ^ be xor operator as in C and C++.
 * 
 * res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4
 * 
 * Since XOR is associative and commutative, above expression can be written as:
 * res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5) ; res = 7 ^ 0 ^ 0 ^ 0 ; res = 7 ^ 0 res
 * = 7;
 * 
 * @param nums
 * @return
 */

public class SingleNumber {
    public static void main(String[] args) {
        int ar[] = { 2, 3, 5, 4, 5, 3, 4 };
        System.out.println(ar);
    }

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}