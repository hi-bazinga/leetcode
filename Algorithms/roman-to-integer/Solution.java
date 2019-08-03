class Solution {
    
    static Map<Character, Integer> symbolMap = new HashMap<>();
    
    static {
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        int previousNum = 0;
        for (int i = 0; i < s.length(); i ++) {
            int curNum = symbolMap.get(s.charAt(i));
            if (curNum <= previousNum) {
                sum += curNum;
            } else {
                sum += curNum - 2 * previousNum;
            }
            previousNum = curNum;
        }
        return sum;
    }
}