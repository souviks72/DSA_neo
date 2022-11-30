//https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1?page=2&category[]=Stack&sortBy=submissions
//https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
class Solution{
    static List<Integer> leftSmaller(int n, int arr[]){
        List<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            int x = arr[i];
            if(st.empty()){
                ls.add(-1);
            }else if(!st.empty()){
                while(!st.empty() && st.peek()>=x){
                    st.pop();
                }
                if(st.empty()){
                    ls.add(-1);
                }else{
                    ls.add(st.peek());
                }
            }
            st.push(x);
        }
        
        return ls;
    }
}