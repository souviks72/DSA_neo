//https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks
//https://www.youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=24
class Solution {
    public boolean isPossible(int v, int[][] prereq)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int m = prereq.length;
        for(int i=0;i<m;i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }
        
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0;j<arr.size();j++){
                indegree[arr.get(j)]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        int c=0;
        while(!q.isEmpty()){
            int x = q.remove();
            c++;
            
            ArrayList<Integer> arr = adj.get(x);
            for(int i=0;i<arr.size();i++){
                indegree[arr.get(i)]--;
                if(indegree[arr.get(i)]==0)
                    q.add(arr.get(i));
            }
        }
        
        if(c==v) return true;
        return false;
    }
    
}