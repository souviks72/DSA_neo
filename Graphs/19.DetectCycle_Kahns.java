//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph
//https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
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
        
        if(c==v) return false;
        return true;
    }
}