//https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13
//https://leetcode.com/problems/permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        fn(0,nums,ls);
        return ls;
    }
    
    public void fn(int idx, int[] nums, List<List<Integer>> ls){
        if(idx == nums.length){
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                arr.add(nums[j]);
            }
            ls.add(arr);
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            fn(idx+1,nums,ls);
            swap(i,idx,nums);
        }
    }
    
    public void swap(int i, int idx, int[] nums){
        int t = nums[i];
        nums[i] = nums[idx];
        nums[idx] = t;
    }
}