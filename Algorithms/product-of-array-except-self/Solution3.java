
public class Solution3 {

    // Solution without division, time: O(n), extra space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        
        // forward traversal
        result[0] = 1;
        for (int i = 0; i <= size - 2; i++) {
            result[i + 1] = result[i] * nums[i];
        }
        
        // backward traverse
        int tmpProduct = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            result[i] = result[i] * tmpProduct;
            tmpProduct *= nums[i];
        }

        return result;
    }
    
    // For test
    public static void main(String[] arg) {
        int[] nums = {1, -2, 3, 4};
        int[] result = new Solution3().productExceptSelf(nums);
        
        for (int i : result)
            System.out.print(i + " ");
    }
    
}
