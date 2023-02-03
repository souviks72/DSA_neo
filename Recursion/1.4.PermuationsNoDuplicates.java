//https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        fn(nums,ls,new ArrayList<Integer>());
        return ls;
    }

    public void fn(int[] nums, List<List<Integer>> ls, ArrayList<Integer> arr){
        if(arr.size()==nums.length){
            ls.add(new ArrayList<>(arr));
        }else{
            for(int i=0;i<nums.length;i++){
                if(arr.contains(nums[i])) continue;
                arr.add(nums[i]);
                fn(nums,ls,arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}