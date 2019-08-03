class Solution {
    
    static String[][] mapping = {
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        {"", "M", "MM", "MMM", "", "", "", "", "", ""}
    };
    
    public String intToRoman(int num) {
        int i = 0;
        String roman = "";
        while (num != 0) {
            int digit = num % 10;
            roman = mapping[i++][digit] + roman;
            num /= 10;
        }
        return roman;
    }
}