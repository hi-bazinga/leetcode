
public class Solution {

    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        calRange(A, 0, A.length - 1, target, result);
        return result;
    }
    
    private void calRange(int[] A, int start, int end, int target, int[] result){
        if (start > end)
            return;
        
        int index = (start + end) / 2;
        
        if (A[index] == target && (index == 0 || A[index] != A[index-1])) {
            result[0] = index;
        }
        
        if (A[index] == target && (index == A.length - 1 || A[index] != A[index+1])) {
            result[1] = index;
        }
        
        calRange(A, start, index - 1, target, result);
        calRange(A, index + 1, end, target, result);
    }
    
    public static void main(String[] args) {
        int[] A = {5,7,7,8,8,10};
        int target = 8;
        int[] result = new Solution().searchRange(A, target);      
        System.out.println(result[0] + " " + result[1]);
    }

}
