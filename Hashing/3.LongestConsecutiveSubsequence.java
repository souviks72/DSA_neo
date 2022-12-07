//https://leetcode.com/problems/longest-consecutive-sequence/
//https://www.youtube.com/watch?v=qgizvmgeyUM&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=3
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(hs.contains(x-1)){
                continue;
            }else{
                int c=0;
                while(hs.contains(x)){
                    c++;
                    x++;
                }
                max = Math.max(c,max);
            }
        }
        return max;
    }
}