//https://practice.geeksforgeeks.org/problems/path-with-minimum-effort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=path-with-minimum-effort
//https://www.youtube.com/watch?v=0ytpZyiZFhA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=37
class Solution {
    
    int MinimumEffort(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)-> x.d - y.d);
        int dist[][] = new int[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        
        while(!pq.isEmpty()){
            Tuple t = pq.remove();
            int diff = t.d;
            int x = t.x;
            int y = t.y;
            
            if(x==rows-1 && y==cols-1) return diff;
            
            for(int i=0;i<4;i++){
                int nr = x + delrow[i];
                int nc = y + delcol[i];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    int newEffort = Math.max(Math.abs(grid[x][y]-grid[nr][nc]),diff);
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Tuple(nr, nc, newEffort));
                    }
                }
            }
        }
        return -1;
    }
}

class Tuple{
    int x,y,d;
    Tuple(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}