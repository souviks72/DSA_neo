//https://leetcode.com/problems/4sum
//https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        if(nums == null || n == 0)
            return new ArrayList<>(set);
        
        Arrays.sort(nums);
                
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                long t2 = target - ((long)nums[i] + (long)nums[j]);
                int front = j+1;
                int back = n-1;

                while(front < back){
                    long sum = nums[front] + nums[back];

                    if(sum < t2) front++;
                    else if(sum > t2) back--;
                    else if(sum == t2){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[front]);
                        ans.add(nums[back]);
                        set.add(ans);

                        while(front < back && nums[front] == ans.get(2)) ++front;
                        while(front < back && nums[back] == ans.get(3)) --back;
                    }
                }
                while(j+1<n && nums[j] == nums[j+1]) ++j;
            }
            while(i+1<n && nums[i] == nums[i+1]) ++i;
        }
        List<List<Integer>> ls = new ArrayList<>(set);
        return ls;
    }
}