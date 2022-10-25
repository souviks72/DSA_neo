//https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
//https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1?page=1&category[]=Matrix&sortBy=submissions
//https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
class Sol
{
    public static int matSearch(int arr[][], int n, int m, int x)
    {
        int i=0,j=m-1;
        while(i<n && i>=0 && j>=0 && j<m){
            if(arr[i][j]==x){
                return 1;
            }else if(arr[i][j]>x){
                j--;
            }else{
                i++;
            }
        }
        return 0;
    }
}