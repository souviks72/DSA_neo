//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=5
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int visited[] = new int[adj.size()];
        for(int i=0;i<visited.length;i++){
            visited[i] = 0;
        }
        
        
        q.add(0);
        visited[0] = 1;
        
        while(q.size()!=0){
            int x = q.remove();
            arr.add(x);
            
            ArrayList<Integer> ls = adj.get(x);
            
            for(int i=0;i<ls.size();i++){
                int y = ls.get(i);
                if(visited[y]==0){
                    visited[y] = 1;
                    q.add(y);
                }
                    
            }
        }
        
        return arr;
    }
}