//https://leetcode.com/problems/sliding-window-maximum/
//https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int l = n-k+1;
        int[] ans = new int[l];
        int i=0,j=0,c=0;
        ArrayList<Integer> ar = new ArrayList<>();
        while(j<n){
            int x = arr[j];
            while(ar.size()>0 && ar.get(ar.size()-1)<x)
                ar.remove(ar.size()-1);
            ar.add(x);
            
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                ans[c] = ar.get(0);
                c++;
                if(arr[i] == ar.get(0))
                    ar.remove(0);
                i++;
                j++;
            }
        }
        return ans;
    }
}