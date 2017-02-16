import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        subResult(candidates, target, 0, subResult, resultList);
        return resultList;
    }

    private void subResult(int[] candidates, int target, int offset, ArrayList<Integer> subResult,
            List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(subResult);
            return;
        }

        if (offset >= candidates.length || candidates[offset] > target)
            return;

        int prev = -1;
        for (int i = offset; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                ArrayList<Integer> tmpResult = new ArrayList<Integer>();
                tmpResult.addAll(subResult);
                tmpResult.add(candidates[i]);

                subResult(candidates, target - candidates[i], i + 1, tmpResult, resultList);
                prev = candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        List<List<Integer>> result = new Solution().combinationSum2(candidates, target);

        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
