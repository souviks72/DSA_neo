//https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
//https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        int j=0;
        while(j<arr.length){
            int x = arr[j];
            pq.add(x);
            
            if(pq.size()>k){
                ans.add(pq.poll());
            }
            j++;
        }
        
        while(pq.size()!=0)
            ans.add(pq.poll());
            
        return ans;
    }
}
