//https://leetcode.com/problems/number-of-squareful-arrays/submissions/890669781/
//https://www.youtube.com/watch?v=qhBVWf0YafA&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=3
class Solution {
    int c = 0;
    public int numSquarefulPerms(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        populateMap(nums,hm);
        fn(nums,hm,new ArrayList<Integer>());
        return c;
    }

    public void fn(int[] nums, HashMap<Integer,Integer> hm, List<Integer> arr){
        if(arr.size()==nums.length){
            System.out.println(arr);
            c++;
        }
        for(Map.Entry<Integer,Integer> m: hm.entrySet()){
            int num = m.getKey();
            int count = m.getValue();
            if(count!=0){
                if(arr.size()>0 && !isSquare(num+arr.get(arr.size()-1))) continue;
                arr.add(num);
                hm.put(num,count-1);
                fn(nums,hm,arr);
                arr.remove(arr.size()-1);
                hm.put(num,count);
                
            }
        }
        
    }

    boolean isSquare(int num){
        int x = (int)Math.sqrt(num);
        return (x*x)==num;
    }

    public void populateMap(int[] nums, HashMap<Integer,Integer> hm){
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
    }
}