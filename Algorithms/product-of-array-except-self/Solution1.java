
public class Solution1 {
    
    // Solution with division, time: O(n), extra space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int zeroNums = 0;
        int zeroIndex = 0;
        int[] result = new int[nums.length];
        
        int allProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums ++;
                zeroIndex = i;
            } else {
                allProduct *= nums[i];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (zeroNums == 0) {
                result[i] = allProduct / nums[i];
            } else if (zeroNums == 1 && zeroIndex == i) {
                result[i] = allProduct;
            } else {
                result[i] = 0;
            }
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