//https://leetcode.com/problems/two-sum/
//https://www.youtube.com/watch?v=dRUpbt8vHpo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(hm.containsKey(diff)){
                int[] ans = new int[2];
                ans[0] = i;
                ans[1] = hm.get(diff);
                return ans;
            }else{
                hm.put(nums[i],i);
            }
        }

        return new int[2];
    }
}