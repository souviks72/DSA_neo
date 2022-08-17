//User function Template for Java
//https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        int k = (int)Math.ceil((sizeOfStack+1)/2.0);
        deleteMidStack(s,k);
    } 
    
    public void deleteMidStack(Stack<Integer> s,int k){
        if (k==1){
            s.pop();
            return;
        }
        
        int x = s.pop();
        k--;
        deleteMidStack(s,k);
        s.push(x);
    }
}
