//https://leetcode.com/problems/next-permutation
//https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
class Solution {
    public void nextPermutation(int[] nums) {
        int bp = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                bp = i;
                break;
            }
        }

        if(bp == -1){
            Arrays.sort(nums);
            return;
        }

        int ngr = -1;
        for(int i=n-1;i>bp;i--){
            if(nums[i]>nums[bp]){
                int t = nums[i];
                nums[i] = nums[bp];
                nums[bp] = t;
                break;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=bp+1;i<n;i++) arr.add(nums[i]);
        Collections.reverse(arr);
        int j=0;
        for(int i=bp+1;i<n;i++) nums[i] = arr.get(j++);
    }
}