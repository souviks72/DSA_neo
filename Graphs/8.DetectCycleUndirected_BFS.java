//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) visited[i] = false;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if (detectCycle(i,V,adj,visited)) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean visited[]){
        visited[src] = true;
        Pair p = new Pair(-1,src);
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        
        while(!q.isEmpty()){
            Pair p2 = q.remove();
            int parent = p2.parent;
            int num = p2.num;
            
            ArrayList<Integer> arr = adj.get(num);
            for(int i=0;i<arr.size();i++){
                int x = arr.get(i);
                if(!visited[x]){
                    visited[x] = true;
                    q.add(new Pair(num, x));
                }else if(x!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair{
    int parent,num;
    Pair(int parent,int num){
        this.parent = parent;
        this.num = num;
    }
}