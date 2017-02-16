
public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
            
        char[] arr = s.toCharArray();
        int base = 1;
        int colNum = 0;
        for (int i = 1; i <= s.length(); i ++) {
            colNum += (arr[arr.length - i] - 64) * base;
            base *= 26;
        }
        return colNum;
    }
}