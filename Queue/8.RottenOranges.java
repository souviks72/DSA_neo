//https://leetcode.com/problems/rotting-oranges
//https://www.youtube.com/watch?v=pUAPcVlHLKA&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=14
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length == 0) return -1;

        Queue<int[]> q = new LinkedList<>();

        int minutes=0,total=0,rotten=0;
        int m=grid.length, n= grid[0].length;

        int dx[] = new int[]{-1,0,1,0};
        int dy[] = new int[]{0,1,0,-1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0)
                    total++;
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(q.size()!=0){
            int s = q.size();
            rotten += s;
            for(int i=0;i<s;i++){
                int[] rot = q.remove();
                for(int j=0;j<4;j++){
                    int x = rot[0] + dx[j];
                    int y = rot[1] + dy[j];
                    if(x<0 || x>=m || y<0 || y>=n || grid[x][y]!=1) continue;
                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                }
            }
            if(q.size()>0)
                minutes++;
        }
        System.out.println(rotten);
        if(rotten != total) return -1;
        return minutes;
    }
}