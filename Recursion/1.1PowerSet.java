//https://leetcode.com/problems/subsets-ii/submissions/890070623/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        fn(nums,ls,arr,0);
        return ls;
        //return new ArrayList<>(hs);
    }

    public void fn(int[] nums, List<List<Integer>> ls, List<Integer> arr, int i){
        if(i==nums.length){
            if(!ls.contains(arr))
                ls.add(new ArrayList<>(arr));
            return;
        }

        List<Integer> ar1 = new ArrayList<>(arr);
        fn(nums,ls,ar1,i+1);
        List<Integer> ar2 = new ArrayList<>(arr);
        ar2.add(nums[i]);
        fn(nums,ls,ar2,i+1);
    }
}