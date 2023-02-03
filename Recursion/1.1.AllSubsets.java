//leetcode.com/problems/subsets
//https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        fn(nums, arr, ls, 0);
        return ls;
    }

    public void fn(int[] nums, List<Integer> arr, List<List<Integer>> ls, int i){
        if(i==nums.length){
            ls.add(new ArrayList<>(arr));
            return;
        }

        ArrayList<Integer> ar1 = new ArrayList<>(arr);
        fn(nums,ar1,ls,i+1);
        ArrayList<Integer> ar2 = new ArrayList<>(arr);
        ar2.add(nums[i]);
        fn(nums,ar2,ls,i+1);
    }
}
