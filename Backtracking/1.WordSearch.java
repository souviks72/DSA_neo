//https://leetcode.com/problems/word-search
//https://www.youtube.com/watch?v=pfiQ_PS1g8E&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo
class Solution {
    static boolean[][] visited;
    static int rows,cols;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        rows = board.length;
        cols = board[0].length;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (dfs(board,word,0,i,j)){
                    return true;
                }  
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board,String word,int i,int r,int c){
        if (i==word.length())
            return true;
        char ch = word.charAt(i);
        if (r<0 || c<0 || r>=rows || c>=cols || board[r][c]!=ch || visited[r][c]) return false;
        
        visited[r][c] = true;
        boolean res = dfs(board,word,i+1,r-1,c)||dfs(board,word,i+1,r+1,c)||dfs(board,word,i+1,r,c-1)||dfs(board,word,i+1,r,c+1);
        
        visited[r][c] = false;
        return res;
    }
}