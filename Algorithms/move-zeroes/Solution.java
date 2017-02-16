
public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                zeroNum ++;
                continue;                
            } else {
                nums[i - zeroNum] = nums[i];
            }
        }
        for (int j = 1; j <= zeroNum; j ++) {
            nums[nums.length - j] = 0;
        }
    }
}