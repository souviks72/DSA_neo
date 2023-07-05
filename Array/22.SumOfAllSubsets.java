//https://practice.geeksforgeeks.org/problems/subset-sums2234
//Striver sheet
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        fn(arr,ans,n,0,0);
        return ans;
    }
    
    public void fn(ArrayList<Integer> arr, ArrayList<Integer> ans, int n, int i, int sum){
        if(i==n){
            ans.add(sum);
            return;
        }
        
        fn(arr,ans,n,i+1,sum);
        fn(arr,ans,n,i+1, sum+arr.get(i));
    }
}