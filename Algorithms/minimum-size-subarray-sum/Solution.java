
public class Solution {

    // time: O(n), space: O(1)
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int tmpSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            tmpSum += nums[i];
            
            if (tmpSum >= s) {
                while (tmpSum >= s && (tmpSum - nums[start]) >= s) {
                    tmpSum -= nums[start];
                    start ++;
                }
                minLen = Math.min(minLen, i - start + 1);
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    // For test
    public static void main(String[] args) {
        int s = 15;
        int nums[] = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int result = new Solution().minSubArrayLen(s, nums);
        System.out.println(result);
    }
}
