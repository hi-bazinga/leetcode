class Solution {

    static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        String letterStr = mapping[digits.charAt(0) - '0'];
        List<String> firstLetters = new ArrayList<>();
        for (int i = 0; i < letterStr.length(); i ++) {
            firstLetters.add(letterStr.substring(i, i + 1));
        }
        
        if (digits.length() == 1) {
            return firstLetters;
        }
        
        List<String> results = new ArrayList<>();
        for (String letter : firstLetters) {
            List<String> combs = letterCombinations(digits.substring(1, digits.length()));
            for (String comb : combs) {
                results.add(letter + comb);
            }
        }
        return results;
    }

}