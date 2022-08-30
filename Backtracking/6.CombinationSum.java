//https://leetcode.com/problems/combination-sum
//https://www.youtube.com/watch?v=GBKI9VSKdGg&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=8
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        List<Integer> cand = new ArrayList<>();
        for(int i=0;i<candidates.length;i++){
            cand.add(candidates[i]);
        }
        dfs(ls,arr,cand,target,0,0);
        return ls;
    }
    
    public void dfs(List<List<Integer>> ls, List<Integer> arr, List<Integer> cand, int target, int sum, int i){
        if (sum > target || i==cand.size()) return;
        if (sum == target){
            ls.add(new ArrayList<Integer>(arr));
            return;
        }
        
        int s1 = sum + cand.get(i);
        arr.add(cand.get(i));
        dfs(ls,arr,cand,target,s1,i);
        arr.remove(arr.size()-1);
        dfs(ls,arr,cand,target,sum,i+1);
    }
}