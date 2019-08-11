class Solution {

    static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> preList = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < digits.length(); i ++) {
            String curLetters = mapping[digits.charAt(i) - '0'];
            for (int j = 0; j < curLetters.length(); j ++) {
                if (preList.size() == 0) {
                    list.add(curLetters.substring(j, j + 1));
                } else {
                    for (int k = 0; k < preList.size(); k ++) {
                        list.add(preList.get(k) + curLetters.substring(j, j + 1));
                    }
                }
            }
            preList = list;
            list = new ArrayList<>();
        }
        return preList;
    }

}