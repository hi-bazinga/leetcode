
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            count ++;
            n &= Integer.MAX_VALUE;
        }
        
        while (n > 0) {
            if (n % 2 == 1)
                count ++;
            n = n / 2;
        }
        return count;
    }
}