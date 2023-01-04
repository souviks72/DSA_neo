//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
//https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        List<Long> ls = new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        int j=0,i=0;
        long x = 0;
        while(j<n){
            if (arr[j] < 0){
                ls.add(arr[j]);
            }
            
            if(j-i+1<k){
                j++;
            }else if(j-i + 1 == k){
                if(ls.size()>0){
                    ans.add(ls.get(0));
                }else{
                    ans.add(x);
                }
                
                if(ls.size()>0 && arr[i]==ls.get(0)){
                    ls.remove(0);
                }
                i++;
                j++;
            }
        }
        
        long[] ar = new long[ans.size()];
        for(int c=0;c<ans.size();c++){
            ar[c] = ans.get(c);
        }
        
        return ar;
    }
}