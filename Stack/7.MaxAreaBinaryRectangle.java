//https://leetcode.com/problems/maximal-rectangle
//https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = -1;
        int n = matrix[0].length;
        int m = matrix.length;
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    arr[i][j] = 0;
                }else{
                    if(i==0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = arr[i-1][j]+1;
                }
            }
        }
              
        for(int i=0;i<m;i++){
            int area = MAH(arr[i],n);
            max = Math.max(area,max);
        }
        return max;
    }
    
    public int MAH(int[] arr, int n){
        int[] left = nsl(arr,n);
        int[] right = nsr(arr,n);
        
        int max = -1;
        for(int i=0;i<n;i++){
            int area = arr[i]*(left[i]+right[i]+1);
            max = Math.max(max,area);
        }
        
        return max;
    }
    
    public int[] nsl(int[] arr, int n){
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            int x = arr[i];
            
            if(st.empty()){
                ans[i]=0;
            }else{
                while(!st.empty() && arr[st.peek()]>=x){
                    st.pop();
                }
                
                if(st.empty()){
                    ans[i] = i;
                }else{
                    ans[i] = i-st.peek()-1;
                }
            }
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsr(int[] arr, int n){
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            int x = arr[i];
            
            if(st.empty()){
                ans[i]=0;
            }else{
                while(!st.empty() && arr[st.peek()]>=x){
                    st.pop();
                }
                
                if(st.empty()){
                    ans[i] = n-i-1;
                }else{
                    ans[i] = st.peek()-i-1;
                }
            }
            st.push(i);
        }
        return ans;
    }
}