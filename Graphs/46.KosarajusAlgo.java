//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=strongly-connected-components-kosarajus-algo
//https://www.youtube.com/watch?v=R6uoSjZ2imo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=54
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(st,adj,vis,i);
            }
        }
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            vis[i] = false;
            for(int it: adj.get(i)){
                revAdj.get(it).add(i);
            }
        }
        
        int scc=0;
        while(!st.isEmpty()){
            int x = st.pop();
            if(!vis[x]){
                scc++;
                dfs2(revAdj, vis, x);
            }
        }
        
        return scc;
    }
    
    private void dfs(Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean vis[], int src){
        vis[src] = true;
        for(int it: adj.get(src)){
            if(!vis[it]){
                dfs(st,adj,vis,it);
            }
        }
        st.push(src);
    }
    
    private void dfs2(ArrayList<ArrayList<Integer>> revAdj, boolean vis[], int src){
        vis[src] = true;
        for(int it: revAdj.get(src)){
            if(!vis[it]){
                dfs2(revAdj,vis,it);
            }
        }
    }
}
