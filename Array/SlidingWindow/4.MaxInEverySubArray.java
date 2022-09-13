//https://www.interviewbit.com/problems/sliding-window-maximum/
//https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] arr, int w) {
        int n = arr.length;
        if(w>=n){
            int max = -999999;
            for(int i=0;i<n;i++){
                max = Math.max(arr[i],max);
            }
            int x[] = new int[1];
            x[0] = max;
            return x;
        }
        int ans[] = new int[n-w+1];
        int c=0;
        Deque<Integer> dq = new LinkedList<Integer>();
        int i;
        for(i=0;i<w;i++){
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        for(;i<n;i++){
            ans[c++] = arr[dq.peek()];
            
            while(!dq.isEmpty() && dq.peek() <= i-w)
                dq.removeFirst();
            
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
                dq.removeLast();
                
            dq.addLast(i);
        }
        ans[c] = arr[dq.peek()];
        return ans;
    }
}