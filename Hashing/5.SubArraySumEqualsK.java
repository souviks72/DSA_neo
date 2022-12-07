//https://leetcode.com/problems/subarray-sum-equals-k
//https://leetcode.com/problems/subarray-sum-equals-k/solutions/127728/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0, count=0;
        hm.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum-k)){
                count += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}