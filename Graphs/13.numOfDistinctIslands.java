//https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands
//https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16
class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i,j,grid,visited,arr,i,j);
                    hs.add(arr);
                }
            }
        }
        
        return hs.size();
    }
    
    public void dfs(int sr, int sc, int[][] grid, boolean[][] visited, ArrayList<String> arr, int br, int bc){
        visited[sr][sc] = true;
        arr.add(toString(sr-br,sc-bc));
        
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nrow = delrow[i]+sr;
            int ncol = delcol[i]+sc;
            if(nrow>=0 &&nrow<grid.length && ncol>=0 && ncol<grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,visited, arr,br,bc);
            }
        }
    }
    
    public String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
