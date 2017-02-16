
public class Solution1 {
    
    /**
     * Only return the max sum
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(tempSum, 0);
            tempSum += nums[i];
            maxSum = Math.max(tempSum, maxSum);
        }
       
        return maxSum;
    }
    
    // For test
    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new Solution().maxSubArray1(nums);
    }

}
