//https://takeuforward.org/data-structure/rotate-image-by-90-degree/
class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        //transpose elements
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        //reverse each row
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }
}