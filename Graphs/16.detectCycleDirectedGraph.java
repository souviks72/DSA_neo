//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph
//https://www.youtube.com/watch?v=9twcmtQj4DU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(dfs(adj, visited, pathVisited, i)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int i){
        visited[i] = true;
        pathVisited[i] = true;
        
        ArrayList<Integer> arr = adj.get(i);
        for(int j=0;j<arr.size();j++){
            int y= arr.get(j);
            if(!visited[y]){
                if(dfs(adj,visited, pathVisited, y)) return true;
            }else if(pathVisited[y]){
                return true;
            }
        }
        
        pathVisited[i] = false;
        return false;
    }
}