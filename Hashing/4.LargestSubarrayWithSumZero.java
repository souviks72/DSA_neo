//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=4
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0, max = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum==0){
                max = i+1;
            }else{
                if (hm.containsKey(sum)){
                    int l = i - hm.get(sum);
                    max = Math.max(max,l);
                }else{
                    hm.put(sum,i);
                }
            }
        }
        
        return max;
    }
}