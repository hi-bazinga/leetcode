class Solution {
    public int reverse(int x) {
        if (x == 0) {return 0;}
        
        List<Integer> list = new ArrayList<>();
        boolean isNegative = x < 0;
        while (x != 0) {
            int digit = x % 10;
            list.add(digit);
            x = x / 10;
        }
        
        int result = 0;
        int prev = 0;
        for (int i = 0; i < list.size(); i ++) {
            prev = result;
            result += list.get(list.size() - i - 1) * (int) Math.pow(10, i);
            if (result % (int) Math.pow(10, i) != prev) {
                return 0;
            }
        }
        return result;
    }
}