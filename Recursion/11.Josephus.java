//https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1
class Solution {
    static int safePos(int n, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        k--;
        findSafe(arr, k, 0);
        return arr.get(0);
    }
    
    public static void findSafe(ArrayList<Integer> arr, int k, int idx){
        if (arr.size()==1){
            return;
        }
        
        idx = (idx+k)%arr.size();
        arr.remove(idx);
        findSafe(arr, k, idx);
    }
};