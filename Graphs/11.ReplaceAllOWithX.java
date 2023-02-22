//User function Template for Java
//https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-os-with-xs
//https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14
class Solution{
    static char[][] fill(int rows, int cols, char mat[][]){
        boolean[][] visited = new boolean[rows][cols];
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        
        //first and last rows
        for(int j=0;j<cols;j++){
            if(!visited[0][j] && mat[0][j]=='O')
                dfs(delrow,delcol,mat,visited, 0, j);
                
            if(!visited[rows-1][j] && mat[rows-1][j]=='O')
                dfs(delrow,delcol,mat,visited, rows-1, j);
        }
        
        //first and last cols
        for(int i=0;i<rows;i++){
            if(!visited[i][0] && mat[i][0]=='O')
                dfs(delrow,delcol,mat,visited, i, 0);
                
            if(!visited[i][cols-1] && mat[i][cols-1]=='O')
                dfs(delrow,delcol,mat,visited, i, cols-1);
        }
        
        //replace all inner untouched "O"s with "X"
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<cols-1;j++){
                if(!visited[i][j] && mat[i][j]=='O')
                    mat[i][j] = 'X';
            }
        }
        
        return mat;
    }
    
    public static void dfs(int[] delrow, int[] delcol, char mat[][], boolean[][] visited, int sr, int sc){
        visited[sr][sc] = true;
        
        for(int i=0;i<4;i++){
            int nrow = sr+delrow[i];
            int ncol = sc+delcol[i];
            if(nrow>=0 && nrow<mat.length && ncol>=0 && ncol<mat[0].length && !visited[nrow][ncol] && mat[nrow][ncol]=='O'){
                dfs(delrow,delcol,mat,visited, nrow, ncol);
            }
        }
    }
}