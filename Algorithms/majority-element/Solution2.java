
public class Solution {

	// quick solution but time complexity increases 
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}