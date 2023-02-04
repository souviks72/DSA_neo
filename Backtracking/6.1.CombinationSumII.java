//https://leetcode.com/problems/combination-sum-ii
//https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        fn(nums, ls, new ArrayList<>(), target, 0 , 0);
        return ls;
        
    }

    public void fn(int[] nums, List<List<Integer>> ls, List<Integer> arr, int target, int sum, int start){
        if(sum==target){
            ls.add(new ArrayList<>(arr));
            return;
        }
        if(sum>target || start==nums.length)
            return;           

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            if(nums[i]>target) break;
            int s = sum + nums[i];
            arr.add(nums[i]);
            fn(nums,ls,arr,target,s,i+1);
            arr.remove(arr.size()-1);
        }
    }
}