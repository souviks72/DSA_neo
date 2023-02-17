//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[V];
        visited[0] = true;
        dfs(adj, visited, arr, 0, V);
        return arr;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> arr, int x, int v){
        if(arr.size()==v)
            return;
        
        arr.add(x);
        
        ArrayList<Integer> ls = adj.get(x);
        for(int i=0;i<ls.size();i++){
            int y = ls.get(i);
            if(!visited[y]){
                visited[y] = true;
                dfs(adj,visited,arr,y, v);
            }
        }
    }
}