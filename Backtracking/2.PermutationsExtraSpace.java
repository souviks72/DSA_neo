//https://leetcode.com/problems/permutations
//https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        fn(ls,arr,visited,nums);
        return ls;
    }
    
    public void fn(List<List<Integer>> ls, List<Integer> arr, boolean[] visited, int[] nums){
        if (arr.size() == nums.length){
            ls.add(new ArrayList<Integer>(arr));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                arr.add(nums[i]);
                visited[i] = true;
                fn(ls,arr,visited,nums);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }
}