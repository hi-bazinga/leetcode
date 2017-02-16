import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
    Arrays.sort(candidates);
    
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    ArrayList<Integer> subResult = new ArrayList<Integer>();
    subResult(candidates, target, 0, subResult, resultList);
    
    return resultList;
    }
  
  private void subResult(int[] candidates, int target, int offset, ArrayList<Integer> subResult, List<List<Integer>> resultList) {
    if (target == 0) {
      resultList.add(subResult);
      return;
    }

    if (offset >= candidates.length || candidates[offset] > target) 
      return;
    
    ArrayList<Integer> tmpResult = new ArrayList<Integer>();
    tmpResult.addAll(subResult);
    tmpResult.add(candidates[offset]);
    subResult(candidates, target - candidates[offset], offset, tmpResult, resultList);
    
    subResult(candidates, target , offset + 1, subResult, resultList);
  }
  
  public static void main(String[] args) {
    int[] candidates = {2,3,6,7};
    int target = 7;
    
    List<List<Integer>> result = new Solution().combinationSum(candidates, target);

    for (List<Integer> list : result) {
      for (Integer i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

}
