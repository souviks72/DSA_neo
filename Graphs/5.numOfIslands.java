//https://leetcode.com/problems/number-of-islands/
//https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][] = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                visited[i][j] = false;
        }

        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }

    private void bfs(char[][] grid, boolean visited[][], int x, int y){
        visited[x][y] = true;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p.x-1>=0 && p.x-1<rows && p.y>=0 && p.y<cols && !visited[p.x-1][p.y] && grid[p.x-1][p.y]=='1'){
                visited[p.x-1][p.y] = true;
                q.add(new Pair(p.x-1,p.y));
            }

            if(p.x+1>=0 && p.x+1<rows && p.y>=0 && p.y<cols && !visited[p.x+1][p.y] && grid[p.x+1][p.y]=='1'){
                visited[p.x+1][p.y] = true;
                q.add(new Pair(p.x+1,p.y));
            }

            if(p.x>=0 && p.x<rows && p.y-1>=0 && p.y-1<cols && !visited[p.x][p.y-1] && grid[p.x][p.y-1]=='1'){
                visited[p.x][p.y-1] = true;
                q.add(new Pair(p.x,p.y-1));
            }

            if(p.x>=0 && p.x<rows && p.y+1>=0 && p.y+1<cols && !visited[p.x][p.y+1] && grid[p.x][p.y+1]=='1'){
                visited[p.x][p.y+1] = true;
                q.add(new Pair(p.x,p.y+1));
            }
        }
    }
}

class Pair{
    int x,y;
    Pair(int x1, int y1){
        x = x1;
        y = y1;
    }
}

//--------------------------------------------DFS-------------------------------------------------
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        boolean vis[][] = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    islands++;
                    dfs(grid,vis,i,j);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, boolean vis[][], int r, int c){
        vis[r][c] = true;
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        for(int i=0;i<4;i++){
            int dr = r + dx[i];
            int dc = c + dy[i];
            if(dr>=0 && dr<grid.length && dc>=0 && dc<grid[0].length && grid[dr][dc]=='1' && !vis[dr][dc]){
                dfs(grid,vis,dr,dc);
            }
        }
    }
}