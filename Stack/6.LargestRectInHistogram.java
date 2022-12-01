//https://leetcode.com/problems/largest-rectangle-in-histogram
//https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = nsl(heights,n);
        int right[] = nsr(heights,n);
        int max = -1;
        for(int i=0;i<n;i++){           
            int area = heights[i]*(left[i]+right[i]+1);
            max = Math.max(area,max);
        }
        
        return max;
    }
    
    public static int[] nsl(int arr[], int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            int x = arr[i];
            
            if(st.empty()){
                ans[i] = 0;
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
    
    public static int[] nsr(int arr[], int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i=n-1;i>=0;i--){
            int x = arr[i];
            
            if(st.empty()){
                ans[i] = 0;
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