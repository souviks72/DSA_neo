// User function Template for Java
//https://practice.geeksforgeeks.org/problems/number-of-enclaves/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-enclaves
//https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15
class Solution {

    int numberOfEnclaves(int[][] grid) {
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,1,-1};
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        
        for(int j=0;j<cols;j++){
            if(!visited[0][j] && grid[0][j]==1)
                dfs(delrow, delcol, grid, visited, 0, j);
                
            if(!visited[rows-1][j] && grid[rows-1][j]==1)
                dfs(delrow, delcol, grid, visited, rows-1, j);
        }
        
        for(int i=0;i<rows;i++){
            if(!visited[i][0] && grid[i][0]==1)
                dfs(delrow, delcol, grid, visited, i, 0);
                
            if(!visited[i][cols-1] && grid[i][cols-1]==1)
                dfs(delrow, delcol, grid, visited, i, cols-1);
        }
        int count=0;
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<cols-1;j++){
                if(!visited[i][j] && grid[i][j]==1)
                    count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int[] delrow, int[] delcol, int[][] grid, boolean visited[][], int sr, int sc){
        visited[sr][sc] = true;
        
        for(int i=0;i<4;i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(delrow, delcol, grid, visited, nrow, ncol);
            }
        }
    }
}