//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        List<Long> res = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        int i=0,j=0;
        while(j<n){
            long x = arr[j];
            if(x<0)
                q.add(x);
            
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(q.size()>0){
                    res.add(q.peek());
                    if(arr[i] == q.peek())
                        q.remove();
                }else{
                    long z = 0;
                    res.add(z);
                }
                i++;
                j++;
            }
        }
        
        long ans[] = new long[res.size()];
        for(i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}