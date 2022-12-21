//https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3
//https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1
class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int ans[] = new int[k];
        k--;
        while(pq.size()!=0){
            ans[k] = pq.poll();
            k--;
        }
        return ans;
    }
}