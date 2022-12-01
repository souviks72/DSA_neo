//https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
//https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            int x = price[i];
            
            if(st.empty()){
                ans[i] = 1;
            }else{
                while(!st.empty() && price[st.peek()]<=x){
                    st.pop();
                }
                
                if(st.empty()){
                    ans[i] = i+1;
                }else{
                    ans[i] = i - st.peek();
                }
            }
            
            st.push(i);
        }
        
        return ans;
    }
    
}