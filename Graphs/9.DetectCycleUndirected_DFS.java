//https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) visited[i] = false;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if (detectCycle(i,V,adj,visited, new Pair(-1,i))) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], Pair p){
        visited[src] = true;
            
        ArrayList<Integer> arr = adj.get(p.num);
        for(int i=0;i<arr.size();i++){
            int x = arr.get(i);
            if(!visited[x]){
                visited[x] = true;
                Pair p2 = new Pair(p.num, x);
                if(detectCycle(x,v,adj,visited,p2)) return true;
            }else if(x!=p.parent){
                return true;
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