//https://leetcode.com/problems/number-of-provinces
//https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7
class Solution {
    public int findCircleNum(int[][] isCon) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = isCon.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isCon[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        
        int count=0;
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int x){
        visited[x] = true;
        ArrayList<Integer> ls = adj.get(x);
        for(int i=0;i<ls.size();i++){
            int y = ls.get(i);
            if(!visited[y]){
                dfs(adj, visited, y);
            }
        }
        
    }
}