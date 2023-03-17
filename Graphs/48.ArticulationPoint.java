//https://practice.geeksforgeeks.org/problems/articulation-point-1/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=articulation-point
//https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/
class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int timer = 1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int[] low = new int[V];
        int[] tin = new int[V];
        boolean[] mark = new boolean[V];
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj, low, tin, mark, vis, i, -1);
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]) arr.add(i);
        }
        
        if(arr.size()==0){
            arr.add(-1);
            return arr;
        }
        
        return arr;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] low, int[] tin, boolean[] mark, boolean[] vis, int node, int parent){
        vis[node] = true;
        low[node] = timer;
        tin[node] = timer;
        timer++;
        
        int child = 0;
        for(int it: adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(adj,low,tin,mark,vis,it,node);
                
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it]>=tin[node] && parent!=-1)
                    mark[node] = true; //articulation point
                    
                child++;
            }else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        
        if(child>1 && parent==-1){
            mark[node] = true;
        }
    }
}