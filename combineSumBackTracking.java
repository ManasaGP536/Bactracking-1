// Time Complexity : Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(target  < 0 || index == candidates.length)
            return;
        
        //logic
        //dont choose
        helper(candidates, target, index+1, path);
        
        //choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, path);
        path.remove(path.size()-1);
    }
}
