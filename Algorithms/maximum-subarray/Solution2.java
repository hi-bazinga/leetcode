
public class Solution2 {

    // Find the max sum, start index and end index
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        
        int tempSum = nums[0];
        int tempStart = 0;
        int tempEnd = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (tempSum < 0) {
                tempSum = nums[i];
                tempStart = i;
            } else {
                tempSum += nums[i];
            }
            tempEnd = i;
            
            if (tempSum > maxSum) {
                maxSum = tempSum;
                start = tempStart;
                end = tempEnd;
            }
        }
       
        System.out.println("Start: " + start + ", End: " + end + ", Sum: " + maxSum);
        return maxSum;
    }

}