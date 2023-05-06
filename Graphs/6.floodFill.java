//https://leetcode.com/problems/flood-fill
//https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] drows = {-1,1,0,0};
        int[] dcols = {0,0,1,-1};
        int rows = image.length;
        int cols = image[0].length;
        int initC = image[sr][sc];

        int[][] ans = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                ans[i][j] = image[i][j];
        }

        dfs(image,sr,sc,color,drows,dcols,ans, initC);
        return ans;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int[] drows, int[] dcols, int[][] ans, int initC){
        ans[sr][sc] = color;
        int rows = image.length;
        int cols = image[0].length;
        

        for(int i=0;i<4;i++){
            int nrow = sr + drows[i];
            int ncol = sc + dcols[i];
            if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && image[nrow][ncol]==initC && ans[nrow][ncol]!=color){
                dfs(image,nrow,ncol,color,drows,dcols,ans, initC);
            }
        }
    }
}