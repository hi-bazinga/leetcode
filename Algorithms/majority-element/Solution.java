
public class Solution {
    
    public int majorityElement(int[] nums) {
        return findKth(nums, 0, nums.length - 1, nums.length / 2);
    }
    
    private int findKth(int[] nums, int begin, int end, int k) {
        if (begin == end)
            return nums[begin];
        
        int itr = begin + 1;
        int pivotPos = begin;
        int pivot = nums[pivotPos];
        
        while (itr <= end) {
            if (nums[itr] < pivot) {
                pivotPos ++;
                swap(nums, itr, pivotPos);
            }
            itr ++;
        }
        swap(nums, begin, pivotPos);
        
        int pivotRank = pivotPos - begin + 1;
        
        if (k == pivotRank) {
            return nums[pivotPos];
        } else if (k < pivotRank) {
            return findKth(nums, begin, pivotPos - 1, k);
        } else {
            return findKth(nums, pivotPos + 1, end, k - pivotRank);
        }
    }
    
    private void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
    
    // For test
    public static void main(String[] args) {
        int[] nums = {3,5,1,7,4,2,9,10};
        int result = new Solution().majorityElement(nums);
        System.out.println(result);
    }
    
}