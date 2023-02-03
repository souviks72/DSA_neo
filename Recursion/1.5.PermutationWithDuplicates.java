//https://leetcode.com/problems/permutations-ii
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        fn(nums,ls,new ArrayList<Integer>(),new boolean[nums.length]);
        return ls;
    }

    public void fn(int[] nums, List<List<Integer>> ls, List<Integer> arr,boolean[] used){
        if(arr.size()==nums.length){
            ls.add(new ArrayList<>(arr));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                arr.add(nums[i]);
                used[i] = true;
                fn(nums,ls,arr,used);
                arr.remove(arr.size()-1);
                used[i] = false;
            }
        }
    }
}