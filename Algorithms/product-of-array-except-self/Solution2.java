
public class Solution2 {

    // Solution without division, time: O(n), extra space: O(n)
    public int[] productExceptSelf1(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int[] tmpRes1 = new int[size];
        int[] tmpRes2 = new int[size];

        tmpRes1[0] = nums[0];
        tmpRes2[0] = nums[size - 1];
        for (int i = 1; i < nums.length; i++) {
            tmpRes1[i] = nums[i] * tmpRes1[i - 1];
            tmpRes2[i] = nums[size - i - 1] * tmpRes2[i - 1];
        }
        
        result[0] = tmpRes2[size - 2];
        result[size - 1] = tmpRes1[size - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = tmpRes1[i - 1] * tmpRes2[size - i - 2];
        }
        
        return result;
    }
    
    // For test
    public static void main(String[] arg) {
        int[] nums = {1, -2, 3, 4};
        int[] result = new Solution1().productExceptSelf(nums);
        
        for (int i : result)
            System.out.print(i + " ");
    }
    
}
