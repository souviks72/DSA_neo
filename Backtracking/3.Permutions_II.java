//https://leetcode.com/problems/permutations-ii/
//https://www.youtube.com/watch?v=qhBVWf0YafA&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=3
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        populateCountMap(hm,nums);
        fn(ls, new ArrayList<Integer>(), hm, nums);
        return ls;
    }
    
    public void fn(List<List<Integer>> ls, List<Integer> arr,HashMap<Integer, Integer> hm, int[] nums){
        if (arr.size() == nums.length){
            ls.add(new ArrayList<Integer>(arr));
            return;
        }
        
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            int num = e.getKey();
            int count = e.getValue();
            if (count != 0){
                arr.add(num);
                hm.put(num,count-1);
                fn(ls,arr,hm,nums);
                arr.remove(arr.size()-1);
                hm.put(num,count);
            }
        }
    }
    
    public void populateCountMap(HashMap<Integer,Integer> hm, int[] nums){
        for(int i=0;i<nums.length;i++){
            if (hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
    }
}