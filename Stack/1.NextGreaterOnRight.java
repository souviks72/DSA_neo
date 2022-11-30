//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[] = new long[n];
        Stack<Long> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            long x = arr[i];
            if(i==n-1 || st.empty()){
                ans[i] = -1;
            }else if(!st.empty()){
                while(!st.empty() && st.peek()<=x){
                    st.pop();
                }
                if(st.empty()){
                    ans[i] = -1;
                }else{
                    ans[i] = st.peek();
                }
            }
            st.push(x);
        }
        
        return ans;
    } 
}