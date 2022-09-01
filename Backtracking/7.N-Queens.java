//https://leetcode.com/problems/n-queens/
//https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        
        int[] leftRow = new int[n];
        int[] sumDiag = new int[2*n-1];
        int[] formDiag = new int[2*n-1];
        
        solve(0,ans,board,leftRow,sumDiag,formDiag,n);
        return ans;
    }
    
    public void solve(int col,List<List<String>> ans,char[][] board,int[] leftRow,int[] sumDiag,int[] formDiag,int n){
        if (col == n){
            constructAns(ans,board);
            return;
        }
        
        for(int row=0;row<n;row++){
            if (leftRow[row]==0 && sumDiag[row+col]==0 && formDiag[(n-1)+(col-row)]==0){
                board[row][col] = 'Q';
                leftRow[row]=1;
                sumDiag[row+col]=1; 
                formDiag[(n-1)+(col-row)]=1;
                
                solve(col+1, ans, board, leftRow, sumDiag, formDiag, n);
                
                board[row][col] = '.';
                leftRow[row]=0;
                sumDiag[row+col]=0; 
                formDiag[(n-1)+(col-row)]=0;
            }
        }
    }
    
    public void constructAns(List<List<String>> ans,char[][] board){
        List<String> arr = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            arr.add(s);
        }
        ans.add(arr);
    }
}