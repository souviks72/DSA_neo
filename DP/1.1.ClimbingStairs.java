//https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        // for(int i=2;i<n;i++){
        //     arr[i] = arr[i-1]+arr[i-2];
        // }

        // return arr[n-1];
        int p1=1,p2=2;
        int count = p1+p2;
        for(int i=2;i<n;i++){
            count = p1+p2;
            p1=p2;
            p2=count;
        }

        return count;
    }
}